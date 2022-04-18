package api;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CallObject {

    /* fields */ 
    double lat;	
    double longt;
    String desc;
    int zipcode;
    String title;
    Timestamp timestamp;
    String city;
    String adress; 
    int index;
  
    /* constructor */
    public CallObject(String lat, String longt, String desc, String zipcode, String title, String timestamp, String city, String adress, String index) {
        this.lat = Double.parseDouble(lat);
        this.longt = Double.parseDouble(longt);
        this.desc = desc;
        this.zipcode = (zipcode.isEmpty()) ? 0 : Integer.parseInt(zipcode.replaceAll("\\s+", ""));
        this.title = title;
        this.timestamp = parseTimeStamp(timestamp);
        this.city = city;
        this.adress = adress;
        this.index = (index.isEmpty()) ? 0 : Integer.parseInt(index.replaceAll("\\s+", ""));
    }
  

    //HELPER FUNCTIONS
    public static Timestamp parseTimeStamp(String strDate) {
        try {
          DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           // you can change format of date
          Date date = formatter.parse(strDate);
          Timestamp timeStampDate = new Timestamp(date.getTime());
    
          return timeStampDate;
        } catch (ParseException e) {
          System.out.println("Exception :" + e);
          return null;
        }
      }
        public String toString() {
            String result = this.title + ", " + this.adress + ", " + this.zipcode + "";
            return result;
        }

}

