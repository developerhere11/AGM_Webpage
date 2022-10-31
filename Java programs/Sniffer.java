import  java.io.*;
import java.util.*;
import java.net.*;

class Packets{
    public String storeSourceIP=new String();
    public int storeSourcePort;

    public ArrayList<String> sourceIP=new ArrayList<>();
    public ArrayList<Integer> sourcePort=new ArrayList<>();

    public String destinationIP=new String();
    public int destinationPort = 32;   /// Pre-decided.
    public Packets(){}

    public Packets(String s, int x){
        this.storeSourceIP=s;
        this.storeSourcePort=x;
        header();

    }

    public void header(){
        try{
        InetAddress localhost = InetAddress.getLocalHost();
        this.destinationIP=(localhost.getHostAddress()).trim();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void print(){
        System.out.println("Source IP:"+this.storeSourceIP+
        " Source Port:"+this.storeSourcePort+
        " Destination IP:" + this.destinationIP+
        " Destination Port:"+this.destinationPort);

    }
}

class Traffic extends Packets{
    {
        header();
    }

    String ip0to255 = "(\\d{1,2}||(0|1)\\d{2}||2[0-4]\\d||25[0-5])";
                // String to check if the inputted IP address are correct
    public String pattern = ip0to255 + "\\." + ip0to255 + "\\." + ip0to255 + "\\." + ip0to255; 

    ArrayList<Packets> packets=new ArrayList<>();
    
    class normalTraffic extends Traffic{;
    
        public void IPScan(){
            System.out.println("Input 5 Valid Source IP address: ");
            ;
            Return :
            for(int i=0; i<5;)
            {
                String s=Sniffer.scan.nextLine();
                if(s.matches(pattern))
                    {
                        sourceIP.add(s);
                        i++;
                    }
                else
                    System.out.println("Input Valid IP address again: ");
                    continue Return;
            }
            System.out.println("Valid IP addresses inputted, next:");

        }
        
        public void PortScan(){

            System.out.println("Input 5 Valid Source Port: ");
            Return :
            for(int i=0; i<5;){
                
                int port=Sniffer.scan.nextInt();
                
                if(port<65536){
                    sourcePort.add(port);
                    i++;
                }
                else
                {
                    System.out.println("Invalid Port, please Input it again");
                    continue Return;
                }
            }
            System.out.println("Valid Ports inputted, next:");

        }
        public void makePackets(){
            for(int i=0; i<5; i++){
                String s=sourceIP.get(i);
                int x=sourcePort.get(i);
                Packets p=new Packets(s, x);
                this.packets.add(p);
            }
        }

    }


    
    class attackTraffic extends Traffic{
        
        public void IPScan(){
            sourceIP=new ArrayList<>();
            System.out.println("Input Source IP address: ");
            int i=-1;
            Return :
            while(i<0){
                
                storeSourceIP=Sniffer.scan.nextLine();
                if(storeSourceIP.matches(pattern))
                    i++;
                else{
                    System.out.println("Input the Source IP again");
                    continue Return;
                }
            }
            System.out.println("Valid IP address inputted, next:");
            
            for(int j=0; j<1050; j++)
            sourceIP.add(storeSourceIP);
        }
        
        public void PortScan(){
            System.out.println("Input Source Port: ");
            int i=-1;
            Return :
            while(i<0){
                
                storeSourcePort=Sniffer.scan.nextInt();
                if(storeSourcePort<65536)
                    i++;
                else{
                    System.out.println("Input the Source IP again");
                    continue Return;
                }
            }
            for(int j=0; j<1050; j++)
            sourcePort.add(storeSourcePort);

            System.out.println("Source port valid, next");
        }
        public void makePackets(){
            for(int i=0; i<1050; i++){
                String s=sourceIP.get(i);
                int x=sourcePort.get(i);
                Packets p=new Packets(s, x);
                this.packets.add(p);
                }
        }
        }
}


class Victim{
    ArrayList<Packets> packets=new ArrayList<Packets>();
    Traffic tf=new Traffic();
    Traffic.normalTraffic nt= tf. new normalTraffic();
    Traffic.attackTraffic at= tf. new attackTraffic();

    public Victim(){}
    public Victim(Traffic.normalTraffic nt){
        this.nt=nt;
    }
    
    public Victim(Traffic.attackTraffic at){
        this.at=at;
    }

    public void Store(Traffic.normalTraffic nt){
        for(int i=0; i<5; i++){
            this.packets.add(this.nt.packets.get(i));
        }
    }

    public void Store(Traffic.attackTraffic at){
            Return:
            for(int i=0; i<1050; i++)
            {
                this.packets.add(this.at.packets.get(i));
                if(this.packets.size()>999){
                    System.out.println("An Attack is Happening!");
                    System.out.println("Number of packets recieved: "+ this.packets.size());
                    break Return;
                }
            }
    }

}


class PortScanning extends Victim{
    Victim victim;

    public PortScanning(Victim vm){
        this.victim = vm;
    }

    public void displayInfo(){
        int size=victim.packets.size();

        if(size>999)
        {
            this.victim.packets.get(0).print();
        }
        else
        for(int i=0; i<size; i++)
        {
            this.victim.packets.get(i).print();
        }
    }
}


public class Sniffer{
    public static final Scanner scan=new Scanner(System.in);
    public static void main(String [] args){
        System.out.println("Enter normal or attack");
        int i=0;
        while(i==0){
        String s=Sniffer.scan.nextLine();
        if(s.trim().equals("normal")){
            Traffic traffic=new Traffic();  //Create objects for traffic and
            Traffic.normalTraffic nt=traffic. new normalTraffic(); // normal traffic
            
            nt.IPScan();  // Scan IP addresses from user.
            nt.PortScan(); // Scan Port number from user.
            nt.makePackets();  // Combine this information
            
            Victim vm=new Victim(nt);
            vm.Store(nt);   // We send this packet information to victim
            
            PortScanning ps=new PortScanning(vm);
            ps.displayInfo(); // Display the information of the packets
            i=1;
            }
        else if(s.trim().equals("attack")){
            Traffic traffic=new Traffic();
            Traffic.attackTraffic at= traffic. new attackTraffic();
            
            at.IPScan();
            at.PortScan();
            at.makePackets();
            
            Victim vm=new Victim(at);
            vm.Store(at);
            
            PortScanning ps=new PortScanning(vm);
            ps.displayInfo();
            i=1;
        }
        else
        System.out.println("Please Input valid information");
    }

    Sniffer.scan.close();
}
}