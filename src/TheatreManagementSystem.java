import java.util.*;
class TheatreManagementSystem
{
    public static void main(String[] args)
    {
        Scanner In = new Scanner(System.in);
        Audience P = new Viewer();
        BookTicket B = new BookTicket();
        System.out.println("\t\t\t\t\tTheatre Management System");
        System.out.println("Enter 1 To Book Ticket\tEnter 2 To Cancel Ticket\tEnter 3 To View Ticket");
        String choice = In.nextLine();
        if(choice.equals("1"))
        {
            P.getDetails();
            P.printDetails();
        }
        else if (choice.equals("2"))
        {
            B.cancelTicket();
        }
        else if(choice.equals("3"))
        {
            System.out.println("\t\t\t\t\tThis Will Only Show Last Booked Ticket");
            B.showTicket();
        }
        else
        {
            System.out.println("Please Enter Available Option");
        }

    }

}