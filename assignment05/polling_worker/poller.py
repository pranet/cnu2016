import boto.sqs
import mysql.connector
import json
import datetime
import time

# Loading Config
config = {}
with open('config.json') as data_file:
    config = json.load(data_file)

cnx = mysql.connector.connect(**config)
cursor = cnx.cursor()


boto_conn = boto.sqs.connect_to_region("us-east-1")
my_queue = boto_conn.get_queue("cnu2016_nagarwal_assignment05")


while True:
    message_at_head = my_queue.read(30)
    while message_at_head is None:
        time.sleep(5)
        message_at_head = my_queue.read(30)
    print message_at_head.get_body()

    data = json.loads(message_at_head.get_body())
    print data
    timestamp = data['timestamp']
    timestamp = datetime.datetime(timestamp['weekyear'],timestamp['monthOfYear'],timestamp['dayOfMonth'],timestamp['hourOfDay'],timestamp['minuteOfHour'],timestamp['secondOfMinute'])
    timestamp = timestamp.isoformat()
    # print timestamp

    add_audit_log = ("INSERT INTO audit_log "
                     "(auditTimestamp, url, parameters, response, ipAddress) "
                     "VALUES ( %(auditTimestamp)s, %(url)s, %(parameters)s, %(response)s, %(ipAddress)s)")
    data_audit_log = {
        "auditTimestamp": timestamp,
        "url": data['url'],
        "parameters": data['parameters'],
        "response": data['responseCode'],
        "ipAddress": data['ipAddress']
    }
    cursor.execute(add_audit_log, data_audit_log)
    cnx.commit()
    my_queue.delete_message(message_at_head)

cursor.close()
cnx.close()