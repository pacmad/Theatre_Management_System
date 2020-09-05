import java.io.*;
class BookTicket
{
    void showTicket()
    {
        try
        {
            FileReader fr = new FileReader("Booking.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null)
            {
                System.out.println(str);
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Please Book Your Ticket");
        }
    }
    void cancelTicket()
    {
        File file = new File("Booking.txt");

        if(file.delete())
        {
            System.out.println("Ticket Cancelled successfully");
        }
        else
        {
            System.out.println("Failed to Cancel the Ticket");
        }
    }
}