package org.ei.opensrp.path.service;

import android.database.Cursor;

import net.sqlcipher.database.SQLiteDatabase;

import org.ei.opensrp.path.repository.PathRepository;
import org.ei.opensrp.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by coder on 5/19/17.
 */
public class HIA2Service {
    private String TAG = HIA2Service.class.getCanonicalName();
    DateFormat dfyymm = new SimpleDateFormat("yyyy-MM");

    private static String EC_CHILD_TABLE = "ec_child";
    private static String CHN1_005 = "CHN1-005";
    private static String CHN1_005_DHIS_ID = "n0uHub5ubqH";
    private static String CHN1_010 = "CHN1-010";
    private static String CHN1_010_DHIS_ID = "IWwblgpMxiS";
    private static String CHN1_011 = "CHN1-011";
    private static String CHN1_011_DHIS_ID = "unknown";
    private static String CHN1_015 = "CHN1-015";
    private static String CHN1_015_DHIS_ID = "fl4bPFJRI5j";
    private static String CHN1_020 = "CHN1-020";
    private static String CHN1_020_DHIS_ID = "ZDSUD6VHnoh";
    private static String CHN1_021 = "CHN1-021";
    private static String CHN1_021_DHIS_ID = "ZDSUD6VHnoh";
    private static String CHN1_025 = "CHN1-025";
    private static String CHN1_025_DHIS_ID = "YAY7yKAkSvq";
    private static String CHN1_030 = "CHN1-030";
    private static String CHN1_030_DHIS_ID = "WFxN7txijYV";
    private static String CHN2_005 = "CHN2-005";
    private static String CHN2_005_DHIS_ID = "adkGrSGNt3L";
    private static String CHN2_010 = "CHN2-010";
    private static String CHN2_010_DHIS_ID = "sSxqU6qPyXr";
    private static String CHN2_015 = "CHN2-015";
    private static String CHN2_015_DHIS_ID = "xIGHv5CY2fF";
    private static String CHN2_020 = "CHN2-020";
    private static String CHN2_020_DHIS_ID = "H5cadfqRh7I";
    private static String CHN2_025 = "CHN2-025";
    private static String CHN2_025_DHIS_ID = "xWDkbLq9kji";
    private static String CHN2_030 = "CHN2-030";
    private static String CHN2_030_DHIS_ID = "e10sC5c4pRz";
    private static String CHN2_035 = "CHN2-035";
    private static String CHN2_035_DHIS_ID = "lcpx7xdVC3z";
    private static String CHN2_040 = "CHN2-040";
    private static String CHN2_040_DHIS_ID = "hi9sRtkzimM";
    private static String CHN2_041 = "CHN2-041";
    private static String CHN2_041_DHIS_ID = "unknown";
    private static String CHN2_045 = "CHN2-045";
    private static String CHN2_045_DHIS_ID = "LpkrzZezPhP";
    private static String CHN2_050 = "CHN2-050";
    private static String CHN2_050_DHIS_ID = "AzLJv6qTtPO";
    private static String CHN2_051 = "CHN2-051";
    private static String CHN2_051_DHIS_ID = "unknown";
    private static String CHN2_055 = "CHN2-055";
    private static String CHN2_055_DHIS_ID = "gdrQ69fCF8B";
    private static String CHN2_060 = "CHN2-060";
    private static String CHN2_060_DHIS_ID = "ke26q8KPQPM";
    private static String CHN2_061 = "CHN2-061";
    private static String CHN2_061_DHIS_ID = "unknown";
    private static String CHN2_065 = "CHN2-065";
    private static String CHN2_065_DHIS_ID = "DSbbltBORY3";
    private static String CHN2_070 = "CHN2-070";
    private static String CHN2_070_DHIS_ID = "JfY9vBHsyzF";
    private static String CHN2_075 = "CHN2-075";
    private static String CHN2_075_DHIS_ID = "B8nBT4kGhtB";
    private static String CHN2_080 = "CHN2-080";
    private static String CHN2_080_DHIS_ID = "G4vWZAJ0uz7";
    private static String CHN3_005 = "CHN3-005";
    private static String CHN3_005_DHIS_ID = "ZTeQmMrVmNR";
    private static String CHN3_005_O = "CHN3-005-O";
    private static String CHN3_005_O_DHIS_ID = "unknown";
    private static String CHN3_010 = "CHN3-010";
    private static String CHN3_010_DHIS_ID = "rwNWKJC4dIO";
    private static String CHN3_010_O = "CHN3-010-O";
    private static String CHN3_010_O_DHIS_ID = "unknown";
    private static String CHN3_015 = "CHN3-015";
    private static String CHN3_015_DHIS_ID = "J3Kd9wHj7mR";
    private static String CHN3_015_O = "CHN3-015-O";
    private static String CHN3_015_O_DHIS_ID = "unknown";
    private static String CHN3_020 = "CHN3-020";
    private static String CHN3_020_DHIS_ID = "Jbxssr389B6";
    private static String CHN3_020_O = "CHN3-020-O";
    private static String CHN3_020_O_DHIS_ID = "unknown";
    private static String CHN3_025 = "CHN3-025";
    private static String CHN3_025_DHIS_ID = "dqsYPg0F8DJ";
    private static String CHN3_025_O = "CHN3-025-O";
    private static String CHN3_025_O_DHIS_ID = "unknown";
    private static String CHN3_027 = "CHN3-027";
    private static String CHN3_027_DHIS_ID = "unknown";
    private static String CHN3_027_O = "CHN3-027-O";
    private static String CHN3_027_O_DHIS_ID = "unknown";
    private static String CHN3_030 = "CHN3-030";
    private static String CHN3_030_DHIS_ID = "poPXN7Wn3RL";
    private static String CHN3_030_O = "CHN3-030-O";
    private static String CHN3_030_O_DHIS_ID = "unknown";
    private static String CHN3_035 = "CHN3-035";
    private static String CHN3_035_DHIS_ID = "N7VEEjo8AdV";
    private static String CHN3_035_O = "CHN3-035-O";
    private static String CHN3_035_O_DHIS_ID = "unknown";
    private static String CHN3_040 = "CHN3-040";
    private static String CHN3_040_DHIS_ID = "R2JLWtup2XR";
    private static String CHN3_040_O = "CHN3-040-O";
    private static String CHN3_040_O_DHIS_ID = "unknown";
    private static String CHN3_045 = "CHN3-045";
    private static String CHN3_045_DHIS_ID = "ujEvTSZ0Wvn";
    private static String CHN3_045_O = "CHN3-045-O";
    private static String CHN3_045_O_DHIS_ID = "unknown";
    private static String CHN3_050 = "CHN3-050";
    private static String CHN3_050_DHIS_ID = "dPpDhpO7GpB";
    private static String CHN3_050_O = "CHN3-050-O";
    private static String CHN3_050_O_DHIS_ID = "unknown";
    private static String CHN3_055 = "CHN3-055";
    private static String CHN3_055_DHIS_ID = "AU3Zp03Atnf";
    private static String CHN3_055_O = "CHN3-055-O";
    private static String CHN3_055_O_DHIS_ID = "unknown";
    private static String CHN3_060 = "CHN3-060";
    private static String CHN3_060_DHIS_ID = "K5XarM6QLxq";
    private static String CHN3_060_O = "CHN3-060-O";
    private static String CHN3_060_O_DHIS_ID = "unknown";
    private static String CHN3_065 = "CHN3-065";
    private static String CHN3_065_DHIS_ID = "ziezVvnYWj0";
    private static String CHN3_065_O = "CHN3-065-O";
    private static String CHN3_065_O_DHIS_ID = "unknown";
    private static String CHN3_070 = "CHN3-070";
    private static String CHN3_070_DHIS_ID = "dpKLNY9JjRR";
    private static String CHN3_070_O = "CHN3-070-O";
    private static String CHN3_070_O_DHIS_ID = "unknown";
    private static String CHN3_075 = "CHN3-075";
    private static String CHN3_075_DHIS_ID = "zIM9ehVMkNW";
    private static String CHN3_075_O = "CHN3-075-O";
    private static String CHN3_075_O_DHIS_ID = "unknown";
    private static String CHN3_80 = "CHN3-80";
    private static String CHN3_80_DHIS_ID = "dzllAar6RrI";
    private static String CHN3_80_O = "CHN3-80-O";
    private static String CHN3_80_O_DHIS_ID = "unknown";
    private static String CHN3_085 = "CHN3-085";
    private static String CHN3_085_DHIS_ID = "sqfX5MniMIH";
    private static String CHN3_085_O = "CHN3-085-O";
    private static String CHN3_085_O_DHIS_ID = "unknown";
    private static String CHN3_090 = "CHN3-090";
    private static String CHN3_090_DHIS_ID = "FGJcw1TCM9D";
    private Map<String, Map<String, Object>> hia2Report = new HashMap<>();
    private SQLiteDatabase database;

    //FIXME to uniquely identify out of areas change group by child.base_entity_id to group by zeir_id
    public void generateIndicators(final SQLiteDatabase _database) {
        database = _database;
    }

    /**
     * Number of male children aged < 12 months who attended a clinic this month.
     *
     * @param database
     */
    private void getCHN1_005(SQLiteDatabase database, String gender) {

        try {
            int count = clinicAttendance("Male");
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN1_005_DHIS_ID, count);
            hia2Report.put(CHN1_005, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, e.getMessage());

        }


    }

    private int clinicAttendance(String gender) {
        Cursor cursor = null;
        int count = 0;
        try {
            String query = "select count(*) as count," + ageQuery() + " from ec_child child inner join " + PathRepository.Table.event.name() + " e on e." + PathRepository.event_column.baseEntityId.name() + "= child.id" +
                    " where age <12 and  strftime('%Y-%m',date('now'))=strftime('%Y-%m',e.eventDate) and child.gender=" + (gender.isEmpty() ? "Male" : gender);
            cursor = database.rawQuery(query, null);
            if (null != cursor) {
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    count = cursor.getInt(0);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.logError(TAG, e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return count;
    }

    /**
     * Number of female children aged < 12 months who attended a clinic this month.
     */
    private void getCHN1_010(SQLiteDatabase db) {
        try {
            int count = clinicAttendance("Female");
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN1_010_DHIS_ID, count);
            hia2Report.put(CHN1_010, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, e.getMessage());

        }

    }

    /**
     * Number of total children aged < 12 months who attended a clinic this month.	"[CHN1-005] + [CHN1-010]
     * [Non-editable in the form]"
     */
    private void getCHN1_011() {

        Map<String, Object> maleCountMap = hia2Report.get(CHN1_005);
        Map<String, Object> femaleCountMap = hia2Report.get(CHN1_010);
        int totalCount = (Integer) maleCountMap.get(CHN1_005_DHIS_ID) + (Integer) femaleCountMap.get(CHN1_010_DHIS_ID);
        Map<String, Object> indicatorMap = new HashMap<>();
        indicatorMap.put(CHN1_011_DHIS_ID, totalCount);
        hia2Report.put(CHN1_011, indicatorMap);

    }

    /**
     * Number of male children aged 12 to 59 months who attended a clinic this month
     */
    private void getCHN1_015(SQLiteDatabase db, String gender) {
        gender = gender == null || gender.isEmpty() ? "Male" : gender;
        String query = "select count(*) as count," + ageQuery() + " from ec_child child inner join event e on e.baseEntityId=child.base_entity_id where  child.gender='" + gender + "' and strftime('%Y-%m',e.eventDate)=strftime('%Y-%m',date('now'))  and age between 12 and 59";

    }

    /**
     * Number of female children aged 12 to 59 months who attended a clinic this month
     */
    private void getCHN1_020(SQLiteDatabase db) {
        getCHN1_015(db, "Female");
    }

    /**
     * Number of Total children aged 12 to 59 months who attended clinic this month
     * [CHN1-015] + [CHN1-020]
     * [Non-editable in the form]
     *
     * @param db
     */
    private void getCHN1_021(SQLiteDatabase db) {

    }

    /**
     * Number of total children < 5 who attended a clinic this month
     * "[CHN1-011] + [CHN1-021]
     * [Non-editable in the form]"
     *
     * @param db
     */
    private void getCHN1_025(SQLiteDatabase db) {

    }

    /**
     * Number of total children who attended clinic and are not part of clinic's catchment area
     * COUNT Number of total children who attended clinic and are not part of clinic's catchment area (i.e., total number of out of catchment area form submissions that month)
     *
     * @param db
     */
    private void getCHN1_030(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count from ec_child child inner join event e on e.baseEntityId=child.base_entity_id where e.eventType like '%Out of Area Service%' and " + eventDateEqualsCurrentMonthQuery();
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN1_030_DHIS_ID, count);
            hia2Report.put(CHN1_030, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN1_030 " + e.getMessage());
        }
    }

    /**
     * Number of total children weighed aged 0-23 months who attended  clinic this month
     * using like for event since this total includes out of area service
     *
     * @param db
     */
    private void getCHN2_005(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count," + ageQuery() + " from ec_child child inner join event e on e.baseEntityId=child.base_entity_id " +
                    "where e.eventType='%Growth Monitoring%' and age <23 and " + eventDateEqualsCurrentMonthQuery();
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_005_DHIS_ID, count);
            hia2Report.put(CHN2_005, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN1_030 " + e.getMessage());
        }
    }

    /**
     * Number of total children weighed aged 24-59 months who attended  clinic this month
     *
     * @param db
     */
    private void getCHN2_010(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count," + ageQuery() + " from ec_child child inner join event e on e.baseEntityId=child.base_entity_id " +
                    "where e.eventType like '%Growth Monitoring%' and age between 24 and 59 and " + eventDateEqualsCurrentMonthQuery();
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_010_DHIS_ID, count);
            hia2Report.put(CHN2_010, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_010 " + e.getMessage());
        }
    }

    /**
     * Number of total children weighed aged < 5 years who attended  clinic this month	"[CHN2-005] + [CHN2-010]
     * [Non-editable in the form]"
     *
     * @param db
     */
    private void getCHN2_015(SQLiteDatabase db) {
        try {
            Map<String, Object> maleCountMap = hia2Report.get(CHN2_005);
            Map<String, Object> femaleCountMap = hia2Report.get(CHN2_010);
            int totalCount = (Integer) maleCountMap.get(CHN2_005_DHIS_ID) + (Integer) femaleCountMap.get(CHN2_010_DHIS_ID);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_015_DHIS_ID, totalCount);
            hia2Report.put(CHN2_015, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_010 " + e.getMessage());

        }
    }

    /**
     * Number of children age 0-23 months who where weighed for = 2 consecutive months who did not gain >100g of weight in those months
     * COUNT number of children 0-23 months [Date_Birth] with [weight current visit - weight previous visits < 100g] who had = 2 consecutive weight encounters at this clinic
     * FIXME
     *
     * @param db
     */

    private void getCHN2_020(SQLiteDatabase db) {

        try {
            String query = "select count(*) as count, child.base_entity_id as beid,strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) as currentweightdate,(w.kg*1000) as currentweight," +
                    "(select (pw.kg*1000) from weights pw where pw.base_entity_id=w.base_entity_id  and strftime('%Y-%m',datetime(pw.date/1000, 'unixepoch'))=strftime('%Y-%m',date('now'),'-1 months')  limit 1) as prevweight," +
                    "(select (pw.kg*1000) from weights pw where pw.base_entity_id=w.base_entity_id  and strftime('%Y-%m',datetime(pw.date/1000, 'unixepoch'))=strftime('%Y-%m',date('now'),'-2 months')  limit 1 ) as last2monthsweight," +
                    ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id where strftime('%Y-%m',date('now'))=currentweightdate and age <23 and (currentweight-prevweight>0 and prevweight-last2monthsweight>0) group by beid";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_020_DHIS_ID, count);
            hia2Report.put(CHN2_020, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_020 " + e.getMessage());
        }

    }

    /**
     * Number of children 24-59 months who where weighed for = 2 consecutive months who did not gain >100g of weight in those months
     * COUNT number of children 24-59 months [Date_Birth]  with [weight current visit - weight previous visits < 100g] who had = 2 consecutive weight encounters at this clinic
     * FIXME
     */
    private void getCHN2_025() {
        try {
            String query = "select count(*) as count, child.base_entity_id as beid,strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) as currentweightdate,(w.kg*1000) as currentweight," +
                    "(select (pw.kg*1000) from weights pw where pw.base_entity_id=w.base_entity_id  and strftime('%Y-%m',datetime(pw.date/1000, 'unixepoch'))=strftime('%Y-%m',date('now'),'-1 months')  limit 1) as prevweight," +
                    "(select (pw.kg*1000) from weights pw where pw.base_entity_id=w.base_entity_id  and strftime('%Y-%m',datetime(pw.date/1000, 'unixepoch'))=strftime('%Y-%m',date('now'),'-2 months')  limit 1 ) as last2monthsweight," +
                    ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id where strftime('%Y-%m',date('now'))=currentweightdate and age between 24 and 59 and (currentweight-prevweight>0 and prevweight-last2monthsweight>0) group by beid";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_025_DHIS_ID, count);
            hia2Report.put(CHN2_025, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_020 " + e.getMessage());
        }

    }

    /**
     * Number of total children age < five years who where weighed for = 2 consecutive months who did not gain >100g of weight in those months
     * "[CHN2-020] + [CHN2-025]
     * [Non-editable in the form]"
     *
     * @param db
     */
    private void getCHN2_030(SQLiteDatabase db) {
        try {
            Map<String, Object> maleCountMap = hia2Report.get(CHN2_020);
            Map<String, Object> femaleCountMap = hia2Report.get(CHN2_025);
            int totalCount = (Integer) maleCountMap.get(CHN2_020_DHIS_ID) + (Integer) femaleCountMap.get(CHN2_025_DHIS_ID);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_030_DHIS_ID, totalCount);
            hia2Report.put(CHN2_030, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_010 " + e.getMessage());

        }

    }

    /**
     * Number of total children age 0-23 months whose weight is between -2Z and -3Z scores
     */
    private void getCHN2_035() {
        try {
            String query = "select count(*) as count," + ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id" +
                    "where strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) and age<=23 and w.z_score between -2 and -3 group by child.base_entity_id;";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_035_DHIS_ID, count);
            hia2Report.put(CHN2_035, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_035 " + e.getMessage());
        }

    }

    /**
     * Number of total children age 24-59 months whose weight is between -2Z and -3Z scores
     */
    private void getCHN2_040() {
        try {
            String query = "select count(*) as count," + ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id" +
                    "where strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) and age between 24 and 59 and w.z_score between -2 and -3 group by child.base_entity_id;";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_040_DHIS_ID, count);
            hia2Report.put(CHN2_040, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_040 " + e.getMessage());
        }

    }

    /**
     * Number of total children age < 5 years whose weight is between -2Z and -3Z scores
     * "[CHN2-035] + [CHN2-040]
     * [Non-editable in the form]"
     */
    private void getCHN2_041() {
        try {
            Map<String, Object> maleCountMap = hia2Report.get(CHN2_035);
            Map<String, Object> femaleCountMap = hia2Report.get(CHN2_040);
            int totalCount = (Integer) maleCountMap.get(CHN2_035_DHIS_ID) + (Integer) femaleCountMap.get(CHN2_040_DHIS_ID);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_041_DHIS_ID, totalCount);
            hia2Report.put(CHN2_041, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_041 " + e.getMessage());

        }

    }

    /**
     * Number of total children age 0-23 months whose weight is below -3Z scores
     *
     * @param db
     */
    private void getCHN2_045(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count," + ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id" +
                    "where strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) and age<=23 and w.z_score< -3 group by child.base_entity_id;";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_045_DHIS_ID, count);
            hia2Report.put(CHN2_045, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_045 " + e.getMessage());
        }
    }

    /**
     * Number of total children age 24-59 months whose weight is below -3Z scores
     *
     * @param db
     */
    private void getCHN2_050(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count," + ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id" +
                    "where strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) and age between 24 and 59 and w.z_score < -3 group by child.base_entity_id;";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_050_DHIS_ID, count);
            hia2Report.put(CHN2_050, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_050 " + e.getMessage());
        }
    }

    /**
     * Number of total children age < 5 years whose weight below -3Z scores
     * [CHN2-045] + [CHN2-050]
     * [Non-editable in the form]
     */
    private void getCHN2_051() {
        try {
            Map<String, Object> maleCountMap = hia2Report.get(CHN2_045);
            Map<String, Object> femaleCountMap = hia2Report.get(CHN2_050);
            int totalCount = (Integer) maleCountMap.get(CHN2_045_DHIS_ID) + (Integer) femaleCountMap.get(CHN2_050_DHIS_ID);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_051_DHIS_ID, totalCount);
            hia2Report.put(CHN2_051, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_051 " + e.getMessage());

        }
    }

    /**
     * Number of total children age 0-23 months whose weight is above 2Z scores
     */
    private void getCHN2_055() {
        try {
            String query = "select count(*) as count," + ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id" +
                    "where strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) and age<=23 and w.z_score>2 group by child.base_entity_id;";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_055_DHIS_ID, count);
            hia2Report.put(CHN2_055, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_055 " + e.getMessage());
        }

    }

    /**
     * Number of total children age 24-59 months whose weight is above 2Z scores
     */
    private void getCHN2_060() {
        try {
            String query = "select count(*) as count," + ageQuery() +
                    "from weights w left join ec_child child on w.base_entity_id=child.base_entity_id" +
                    "where strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(w.date/1000, 'unixepoch')) and age between 24 and 59 and w.z_score >2 group by child.base_entity_id;";

            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_060_DHIS_ID, count);
            hia2Report.put(CHN2_060, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_060 " + e.getMessage());
        }

    }

    /**
     * Number of total children age < 5 years whose weight is above 2Z scores
     * [CHN-055] + [CHN-060]
     *
     * @param db
     */
    private void getCHN2_061(SQLiteDatabase db) {
        try {
            Map<String, Object> maleCountMap = hia2Report.get(CHN2_045);
            Map<String, Object> femaleCountMap = hia2Report.get(CHN2_050);
            int totalCount = (Integer) maleCountMap.get(CHN2_045_DHIS_ID) + (Integer) femaleCountMap.get(CHN2_050_DHIS_ID);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_051_DHIS_ID, totalCount);
            hia2Report.put(CHN2_051, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_051 " + e.getMessage());

        }
    }

    /**
     * Number of children age 6-11 months who received vitamin A at this facility in this month
     *
     * @param db
     */
    private void getCHN2_065(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count, " + ageQuery() + " from recurring_service_records rsr inner join recurring_service_types rst on rsr.recurring_service_id=rst._id left join ec_child child on rsr.base_entity_id=child.base_entity_id\n" +
                    "where rst.type='vit_a' and strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(rsr.date/1000, 'unixepoch')) and age between 6 and 11";

            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_065_DHIS_ID, count);
            hia2Report.put(CHN2_065, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_065 " + e.getMessage());
        }

    }

    /**
     * Vitamin A supplement to infant and children 12-59 months
     *
     * @param db
     */
    private void getCHN2_070(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count," + ageQuery() + " from recurring_service_records rsr inner join recurring_service_types rst on rsr.recurring_service_id=rst._id left join ec_child child on rsr.base_entity_id=child.base_entity_id\n" +
                    "where rst.type='vit_a' and strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(rsr.date/1000, 'unixepoch')) and age between 12 and 59";
            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_070_DHIS_ID, count);
            hia2Report.put(CHN2_070, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_070 " + e.getMessage());
        }
    }

    /**
     * Number of children age 12-59 months who received a deworming dose at this facility in this month
     *
     * @param db
     */
    private void getCHN2_075(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count," + ageQuery() + " from recurring_service_records rsr inner join recurring_service_types rst on rsr.recurring_service_id=rst._id left join ec_child child on rsr.base_entity_id=child.base_entity_id\n" +
                    "where rst.type='deworming' and strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(rsr.date/1000, 'unixepoch')) and age between 12 and 59";

            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_075_DHIS_ID, count);
            hia2Report.put(CHN2_075, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_075 " + e.getMessage());
        }

    }

    /**
     * Number of children who received insecticide treated nets at this facility in this month
     *
     * @param db
     */
    private void getCHN2_080(SQLiteDatabase db) {
        try {
            String query = "select count(*) as count from recurring_service_records rsr inner join recurring_service_types rst on rsr.recurring_service_id=rst._id left join ec_child child on rsr.base_entity_id=child.base_entity_id\n" +
                    "where rst.type='itn' and strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(rsr.date/1000, 'unixepoch'))";

            int count = executeQueryAndReturnCount(query);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN2_080_DHIS_ID, count);
            hia2Report.put(CHN2_080, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN2_080 " + e.getMessage());
        }

    }

    /**
     * Number of children < one year who received BCG dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_005(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("bcg", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_005_DHIS_ID, count);
            hia2Report.put(CHN3_005, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_005 " + e.getMessage());
        }

    }

    /**
     * Number of children < one year who received BCG dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_005_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("bcg", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_005_O_DHIS_ID, count);
            hia2Report.put(CHN3_005_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_005_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV0 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_010(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("opv_0", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_010_DHIS_ID, count);
            hia2Report.put(CHN3_010, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_010 " + e.getMessage());
        }

    }

    /**
     * Number of children < one year who received OPV0 dose at outreach conducted by this facility in this month
     */
    private void getCHN3_010_O() {
        try {
            int count = getVaccineCount("opv_0", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_010_O_DHIS_ID, count);
            hia2Report.put(CHN3_010_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_010 " + e.getMessage());
        }

    }

    /**
     * Number of children < one year who received OPV1 dose at this facility in this month
     */
    private void getCHN3_015() {
        try {
            int count = getVaccineCount("opv_1", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_015_DHIS_ID, count);
            hia2Report.put(CHN3_015, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_015 " + e.getMessage());
        }

    }

    /**
     * Number of children < one year who received OPV1 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_015_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("opv_1", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_015_O_DHIS_ID, count);
            hia2Report.put(CHN3_015_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_015_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV2 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_020(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("opv_2", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_020_DHIS_ID, count);
            hia2Report.put(CHN3_020, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_020 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV2 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_020_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("opv_2", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_020_O_DHIS_ID, count);
            hia2Report.put(CHN3_020_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_020_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV3 dose at this facility in this month
     */
    private void getCHN3_025() {
        try {
            int count = getVaccineCount("opv_3", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_025_DHIS_ID, count);
            hia2Report.put(CHN3_025, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_025 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV3 dose at outreach conducted by this facility in this month
     */
    private void getCHN3_025_O() {
        try {
            int count = getVaccineCount("opv_3", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_025_O_DHIS_ID, count);
            hia2Report.put(CHN3_025_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_025 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received IPV dose at this facility in this month
     */
    private void getCHN3_027() {
        try {
            int count = getVaccineCount("ipv", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_027_DHIS_ID, count);
            hia2Report.put(CHN3_027, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_027 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received IPV dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_027_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("ipv", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_027_O_DHIS_ID, count);
            hia2Report.put(CHN3_027_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_027_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV4 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_030(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("opv_4", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_030_DHIS_ID, count);
            hia2Report.put(CHN3_030, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_030 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received OPV4 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_030_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("opv_4", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_030_O_DHIS_ID, count);
            hia2Report.put(CHN3_030_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_030_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received DPT-Hib+HepB 1 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_035(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("penta_1", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_035_DHIS_ID, count);
            hia2Report.put(CHN3_035, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_035 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received DPT-Hib+HepB 1 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_035_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("penta_1", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_035_O_DHIS_ID, count);
            hia2Report.put(CHN3_035_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_035 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received DPT-Hib+HepB 2 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_040(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("penta_2", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_040_DHIS_ID, count);
            hia2Report.put(CHN3_040, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_040 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received DPT-Hib+HepB 2 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_040_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("penta_2", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_040_O_DHIS_ID, count);
            hia2Report.put(CHN3_040_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_040_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received DPT-Hib+HepB 3 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_045(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("penta_3", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_045_DHIS_ID, count);
            hia2Report.put(CHN3_045, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_045 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received DPT-Hib+HepB 3 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_045_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("penta_3", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_045_O_DHIS_ID, count);
            hia2Report.put(CHN3_045_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_045_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received PCV 1 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_050(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("pcv_1", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_050_DHIS_ID, count);
            hia2Report.put(CHN3_050, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_050 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received PCV 1 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_050_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("pcv_1", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_050_O_DHIS_ID, count);
            hia2Report.put(CHN3_050_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_050_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received PCV 2 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_055(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("pcv_2", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_055_DHIS_ID, count);
            hia2Report.put(CHN3_055, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_055 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received PCV 2 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_055_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("pcv_2", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_055_O_DHIS_ID, count);
            hia2Report.put(CHN3_055_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_055_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received PCV 3 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_060(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("pcv_3", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_060_DHIS_ID, count);
            hia2Report.put(CHN3_060, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_060 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received PCV 3 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_060_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("pcv_3", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_060_O_DHIS_ID, count);
            hia2Report.put(CHN3_060_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_060_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received RV 1  dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_065(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("rota_1", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_065_DHIS_ID, count);
            hia2Report.put(CHN3_065, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_065 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received RV 1 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_065_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("rota_1", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_065_O_DHIS_ID, count);
            hia2Report.put(CHN3_065_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_065_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received RV 2  dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_070(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("rota_2", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_070_DHIS_ID, count);
            hia2Report.put(CHN3_070, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_070 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received RV 2 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_070_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("rota_2", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_070_O_DHIS_ID, count);
            hia2Report.put(CHN3_070_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_070_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received Measles/ MR 1 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_075(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("measles_1", "<12", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_075_DHIS_ID, count);
            hia2Report.put(CHN3_075, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_075 " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who received Measles/ MR dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_075_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("measles_1", "<12", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_075_O_DHIS_ID, count);
            hia2Report.put(CHN3_075_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_075_O " + e.getMessage());
        }
    }

    /**
     * Number of children < one year who have received the complete BCG, OPV series, DPT-Hib+Hep1 series, PCV series , RV series and measles/MR 1 within 10 days of each antigen being due at this facility
     *
     * @param db FIXME
     */
    private void getCHN3_80(SQLiteDatabase db) {

    }

    /**
     * Number of children < one year who have received the complete BCG, OPV series, DPT-Hib+Hep1 series, PCV series , RV series and measles/MR 1 within 10 days of each antigen being due at outreach conducyed by this facility
     *
     * @param db FIXME
     */
    private void getCHN3_80_O(SQLiteDatabase db) {

    }

    /**
     * Number of children at 18 months  who received Measles/ MR 2 dose at this facility in this month
     *
     * @param db
     */
    private void getCHN3_085(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("measles_1", "18", false);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_085_DHIS_ID, count);
            hia2Report.put(CHN3_085, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_085 " + e.getMessage());
        }
    }

    /**
     * Number of children  at 18 months who received Measles/ MR 2 dose at outreach conducted by this facility in this month
     *
     * @param db
     */
    private void getCHN3_085_O(SQLiteDatabase db) {
        try {
            int count = getVaccineCount("measles_1", "18", true);
            Map<String, Object> indicatorMap = new HashMap<>();
            indicatorMap.put(CHN3_085_O_DHIS_ID, count);
            hia2Report.put(CHN3_085_O, indicatorMap);
        } catch (Exception e) {
            Log.logError(TAG, "CHN3_085_O " + e.getMessage());
        }
    }

    /**
     * Number of days during the month that vaccine storage fridge was not functioning
     * FIXME
     *
     * @param db
     */
    private void getCHN3_090(SQLiteDatabase db) {

    }

    /**
     * @param vaccine
     * @param age       in months specified as e.g <12 or >12 or between 12 and 59
     * @param outOfArea
     * @return
     */
    private int getVaccineCount(String vaccine, String age, boolean outOfArea) {
        int count = 0;
        try {
            String vaccineCondition = vaccine.contains("measles") ? "(lower(v.name)='" + vaccine.toLowerCase() + "' or lower(v.name)='mr_1')" : "lower(v.name)='" + vaccine.toLowerCase() + "'";
            String query = "select count(*) as count, " + ageQuery() + " from vaccines v left join ec_child child on child.base_entity_id=v.base_entity_id " +
                    "where age " + age + " and  strftime('%Y-%m',date('now'))=strftime('%Y-%m',datetime(v.date/1000, 'unixepoch')) and v.out_of_area=" + (outOfArea ? 1 : 0) + " and " + vaccineCondition;
            count = executeQueryAndReturnCount(query);
        } catch (Exception e) {
            Log.logError(TAG, vaccine.toUpperCase() + e.getMessage());
        }

        return count;

    }

    private String ageQuery() {
        return "CAST ((julianday('now') - julianday(strftime('%Y-%m-%d',child.dob)))/(365/12) AS INTEGER)as age";
    }

    private String eventDateEqualsCurrentMonthQuery() {
        return "strftime('%Y-%m',e.eventDate) = strftime('%Y-%m',date('now'))";
    }

    private int executeQueryAndReturnCount(String query) {
        Cursor cursor = null;
        int count = 0;
        try {
            cursor = database.rawQuery(query, null);
            if (null != cursor) {
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    count = cursor.getInt(0);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.logError(TAG, e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return count;
    }
}
