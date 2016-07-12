from dateutil import parser
import re
import datetime
class HelperFunctions:
    @staticmethod
    def format_date_to_iso_format(date):
        date = str(date)
        formatted_date = parser.parse(date)
        formatted_date = formatted_date.isoformat()
        formatted_date = datetime.datetime.strptime(str(formatted_date), '%Y-%m-%dT%H:%M:%S').strftime('%m/%d/%yT%H:%M:%S')
        return formatted_date
    @staticmethod
    def remove_braces(line):
        return re.sub('[{}]', '', line)
