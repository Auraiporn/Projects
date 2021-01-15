// Write a program that returns the acute angle between two hands of a clock
/**
 * A clock at 12 o'clock: 360 angle.
 * Angle between hand and minute = angle of hour hand - angle of minute hand.
 * We want to get the smaller angle.
 * An angle of hour moves 360 in 12 hours: 360/12 = 30 degree in one hour and 30/60 = 0.5 degree in one minute.
 * An angle of minute moves 360 in 60 minutes: 360/60 = 6 degree in one minute.
 * Given time hour and minute; an hour will move [ (hour*60 + minute)*0.5 ] , and a minute hand will move [ 6*minute]
 * */

public class Clock_Angle {
    /** A function returns the acute angle between two hands of a clock.
     * It returns -1 if the input is invalid. */
    public static double angleOfClock(int hour, int minute){
        if(hour < 0 || minute < 0 || hour > 12 || minute >60) return -1;
        if(hour==12) hour = 0;
        if(minute==60){
            minute = 0;
            hour = hour+1;
        }
        double hourAngle = (double)(hour*60 + minute)*0.5;
        double minuteAngle = (double)(6*minute);
        // find the difference hour angle and minute angle
        double angle = Math.abs(hourAngle - minuteAngle);
        // Obtain a smaller angle of two possible angle
        angle = Math.min(360-angle, angle);
        return angle;
    }
    public static void main(String[] args){
        System.out.println(angleOfClock(10, 0));
        System.out.println(angleOfClock(4, 30));
        System.out.println(angleOfClock(12, 35));
        System.out.println(angleOfClock(3, 10));

    }
}
