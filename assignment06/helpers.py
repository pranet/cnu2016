from dateutil import parser
import datetime
class HelperFunctions:
    @staticmethod
    def format_date_to_iso_format(date):
        date = str(date)
        formatted_date = parser.parse(date)
        return formatted_date.isoformat()
    @staticmethod
    def iso_format_to_default_format(timestamp):
        converted_date = datetime.datetime(timestamp)
        return converted_date