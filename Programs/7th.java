// WAP to convert seconds into days, hours, minutes and seconds.
class myClass{
    public static void main(String [] args) {
        int totalSecs = 234444;

        String timeString = myClass.secToTime(totalSecs);
        System.out.println(timeString);
    }

    static String secToTime(int sec) {
        int seconds = sec % 60;
        int minutes = sec / 60;
        if (minutes >= 60) {
            int hours = minutes / 60;
            minutes %= 60;
            if( hours >= 24) {
                int days = hours / 24;
                return String.format("%d days %02d:%02d:%02d", days,hours%24, minutes, seconds);
            }
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        return String.format("00:%02d:%02d", minutes, seconds);
    }
}
