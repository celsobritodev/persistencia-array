
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class javalabclass {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //this is a demo on serializadtion and deserialization of an array of objects
        employee e[] = new employee[2];
        System.out.println("Enter the employee deatails");
        Scanner input = new Scanner(System.in);
        String name, empid, address;
        ObjectOutputStream objout = new ObjectOutputStream ( new FileOutputStream("satish.txt"));
        for (int i = 0; i < e.length; i++) {
            System.out.println("Enter the employee name");
            name = input.nextLine();
            System.out.println("Enter the employeee id");
            empid = input.nextLine();
            System.out.println("Enter the employee address");
            address = input.nextLine();
            e[i] = new employee(name, empid, address);
            objout.writeObject(e[i]);
        }
        objout.writeObject(new endooffile());
        objout.close();
        
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream("satish.txt"));
        Object obj = null;
        while((obj=objin.readObject()) instanceof endooffile == false ) 
        {
            System.out.println((
                    (employee)obj).name+
                    ((employee)obj).empid+
                    ((employee)obj).address);
        }
        objin.close();
    }

}

class employee implements Serializable {

    String name;
    String empid;
    String address;

    public employee(String name, String empid, String address) {
        super();
        this.name = name;
        this.empid = empid;
        this.address = address;
    }
}


class endooffile implements Serializable
{
    
    
}