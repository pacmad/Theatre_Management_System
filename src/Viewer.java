import java.util.*;
import java.io.*;
class Viewer extends Audience
{
    String Name,Mail,MyMobile,Ticket,option;
    String Theatre,TicketType,Movie;
    String regex1 = "(0/91)?[7-9][0-9]{9}";
    String regex2 = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    long Mobile;

    void getDetails() {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        Name = Sc.nextLine();
        System.out.println("Enter Your Mobile Number:");
        Mobile = Sc.nextLong();
        MyMobile = Long.toString(Mobile);
        Sc.nextLine();
        System.out.println("Enter Your Email Id:");
        Mail = Sc.nextLine();
        System.out.println("\t\t\t\t\tChoose Your Theatre");
        System.out.println("Enter 1 For Carnival\tEnter 2 For PVR Curo\tEnter 3 For Pvr Md");
        Theatre = Sc.nextLine();
        System.out.println("\t\t\t\t\tChoose Your Movie");
        System.out.println("Enter 1 For BlackWidow\tEnter 2 For Dune\tEnter 3 For Star wars");
        TicketType = Sc.nextLine();
        System.out.println("\t\t\t\t\tEnter Type Of Your Ticket:");
        System.out.println("Enter 1 For SilverClass\tEnter 2 For GoldenClass\tEnter 3 For PlatinumClass");
        option = Sc.nextLine();
    }

    void printDetails() {
        try{
            FileWriter fw = new FileWriter("Booking.txt");
            PrintWriter pw = new PrintWriter(fw);
            GoldenClass S = new GoldenClass();
            PlatinumClass PS = new PlatinumClass();
            SilverClass AR = new SilverClass();
            Random rand = new Random();
            System.out.println("\t\t\tYour Ticket Details");
            int rand_int1 = rand.nextInt(10000);
//        System.out.println("Booking Id: "+rand_int1);
            pw.println("Booking Id: "+rand_int1);
//        System.out.println("Name: " + Name);
            pw.println("Name: " + Name);
            if(MyMobile.matches(regex1) && Mail.matches(regex2))
            {
//                System.out.println("Mobile: " + MyMobile);
                pw.println("Mobile: " + MyMobile);
//                System.out.println("MailID:"+ Mail);
                pw.println("MailID:"+ Mail);
                if (Theatre.equals("1"))
                {
                    Theatre = "Carnival";
                    pw.write("Theatre:"+Theatre+"\n");

                }
                else if (Theatre.equals("2"))
                {
                    Theatre = "PVR Curo";
                    pw.write("Theatre:"+Theatre+"\n");

                }

                else if (Theatre.equals("3"))
                {
                    Theatre = "PVR Md";
                    pw.write("Theatre:"+Theatre+"\n");

                }
                else
                {
                    System.out.println("Only These Three Movies Are Available");
                }
                if (TicketType.equals("1"))
                {
                    Movie = "BlackWidow";
                    pw.write("Movie:"+Movie+"\n");

                }
                else if (TicketType.equals("2"))
                {
                    Movie = "Dune";
                    pw.write("Movie:"+Movie+"\n");

                }

                else if (TicketType.equals("3"))
                {
                    Movie = "StarWars";
                    pw.write("Movie:"+Movie+"\n");

                }
                else
                {
                    System.out.println("Only These Three Movies Are Available");
                }
                if (option.equals("1")) {
                    Ticket = "SilverClass";
//                  System.out.println("Ticket: " + Ticket);
                    pw.println("Ticket: " + Ticket);
                    AR.price();
                } else if (option.equals("2")) {
                    Ticket = "GoldenClass";
//                  System.out.println("Ticket: " + Ticket);
                    pw.println("Ticket: " + Ticket);
                    S.price();
                } else if (option.equals("3")) {
                    Ticket = "PlatinumClass";
//                  System.out.println("Ticket: " + Ticket);
                    pw.println("Ticket: " + Ticket);
                    PS.price();

                } else {
                    System.out.println("Only Enter Available Tickets");
                }
                pw.close();

                FileReader fr = new FileReader("Booking.txt");
                BufferedReader br = new BufferedReader(fr);

                String str;
                while ((str = br.readLine()) != null)
                {
                    System.out.println(str);
                }
                br.close();
                System.out.println("\t\t\t\t\tBooking Successful");
            }
            else
            {
                System.out.println("Invalid Mobile no or EmailId ");
                getDetails();
                printDetails();
            }
        }

        catch(IOException e)
        {
            System.out.println("Please Book Your Ticket");
        }

    }

}