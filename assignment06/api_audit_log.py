from flask import Flask,jsonify, request
from flask_sqlalchemy import SQLAlchemy
import datetime
import dateutil.parser as parser

from helpers import HelperFunctions
app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = "mysql+pymysql://nagarwal:nagarwal@aline-cnu-insights-dev-cluster.cluster-czuocyoc6awe.us-east-1.rds.amazonaws.com:3306/cnu2016_nagarwal"
db = SQLAlchemy(app)

class audit_log(db.Model):
    idAuditLog = db.Column(db.Integer, primary_key = True)
    auditTimeStamp = db.Column(db.DATETIME)
    url = db.Column(db.VARCHAR)
    parameters = db.Column(db.VARCHAR)
    response = db.Column(db.Integer)
    ipAddress = db.Column(db.VARCHAR)

    def __init__(self, audit_time_stamp,  url, parameters, response, ip_address):
        self.auditTimeStamp = audit_time_stamp
        self.url = url
        self.parameters = parameters
        self.response = response
        self.ipAddress = ip_address

    def as_json(self):
        return {
            "idAuditLog":self.idAuditLog,
            "auditTimeStamp": HelperFunctions.format_date_to_iso_format(self.auditTimeStamp),
            # "auditTimeStamp": self.auditTimeStamp,
            "url":self.url,
            "parameters":self.parameters,
            "response":self.response,
            "ipAddress": self.ipAddress
        }





@app.route("/api/auditLogs", methods=['GET'])
def get_audit_logs():
    startTime = request.args.get('startTime')
    endTime = request.args.get('endTime')
    lim = request.args.get('limit', 10)
    off = request.args.get('offset', 0)
    if startTime is not None and endTime is not None:
        startTime = parser.parse(startTime)
        endTime = parser.parse(endTime)
        return jsonify(data=[al.as_json() for al in audit_log.query
                       .order_by(audit_log.auditTimeStamp.desc())
                       .filter(audit_log.auditTimeStamp.between(startTime, endTime))
                       .limit(lim).offset(off).all()])
    else:
        return jsonify(data=[al.as_json() for al in audit_log.query
                       .order_by(audit_log.auditTimeStamp.desc())
                       .limit(lim).offset(off).all()])



if __name__ == '__main__':
    app.run(debug=True)