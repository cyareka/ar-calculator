import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ARCalculator {
   public static void main(String args[]) {

      // Reference Index
      int[] AR_EXP_TABLE = new int[21];
      AR_EXP_TABLE[0] = 145_375; // AR 40
      AR_EXP_TABLE[1] = 155_925; // AR 41
      AR_EXP_TABLE[2] = 167_450; // AR 42
      AR_EXP_TABLE[3] = 179_925; // AR 43
      AR_EXP_TABLE[4] = 193_375; // AR 44
      AR_EXP_TABLE[5] = 207_775; // AR 45
      AR_EXP_TABLE[6] = 223_125; // AR 46
      AR_EXP_TABLE[7] = 239_450; // AR 47
      AR_EXP_TABLE[8] = 256_725; // AR 48
      AR_EXP_TABLE[9] = 274_975; // AR 49
      AR_EXP_TABLE[10] = 294_175; // AR 50
      AR_EXP_TABLE[11] = 320_575; // AR 51
      AR_EXP_TABLE[12] = 349_375; // AR 52
      AR_EXP_TABLE[13] = 380_575; // AR 53
      AR_EXP_TABLE[14] = 414_175; // AR 54
      AR_EXP_TABLE[15] = 450_175; // AR 55
      AR_EXP_TABLE[16] = 682_525; // AR 56
      AR_EXP_TABLE[17] = 941_475; // AR 57
      AR_EXP_TABLE[18] = 1_227_225; // AR 58
      AR_EXP_TABLE[19] = 1_540_050; // AR 59
AR_EXP_TABLE[20] = 1_880_175; // AR 60

      // Input values here
      int MY_AR_EXP = 172_526;
      int MY_AR_INDEX = 18;
      int WANTED_AR_INDEX = 19;
      String CURRENT_DATE = "XXXX-XX-XX";

      // Calculations
      int RESIN_USAGE_PER_DAY = 180;
      int EXP_PER_20_RESIN = 100;
      int DAILY_COMMISSION_EXP = 500 + (4 * 250);
      int RESIN_EXP_PER_DAY = RESIN_USAGE_PER_DAY / 20 * EXP_PER_20_RESIN;
      int EXP_GAIN_PER_DAY = DAILY_COMMISSION_EXP + RESIN_EXP_PER_DAY;
      int TOTAL_EXP_REQUIRED = AR_EXP_TABLE[WANTED_AR_INDEX] - AR_EXP_TABLE[MY_AR_INDEX] - MY_AR_EXP;

      // Day Estimate
      int DAYS_TIL_AR_GOAL = TOTAL_EXP_REQUIRED / EXP_GAIN_PER_DAY;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      Calendar cal = Calendar.getInstance();
      try {
         cal.setTime(sdf.parse(CURRENT_DATE));
      } catch (ParseException e) {
         e.printStackTrace();
      }

      cal.add(Calendar.DAY_OF_MONTH, DAYS_TIL_AR_GOAL);
      String EXPECTED_DATE = sdf.format(cal.getTime());

      // Output
      System.out.println("-----------------------------------\nSHEARDEEH'S AR CALCULATOR\n-----------------------------------");
      System.out.println("Total EXP Required: " + TOTAL_EXP_REQUIRED);
      System.out.println("Est. Days Until AR Goal: " + DAYS_TIL_AR_GOAL);
      System.out.println("Expected AR Goal Date: " + EXPECTED_DATE + "\n-----------------------------------");
   }
}