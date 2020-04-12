package Lab6;
//He Lin's code

public class Q5Packet {

    enum type {
        VOICE, VIDEO, DATA;
    }
    type t ;
    String index;
    public Q5Packet(String indentifier){
        index = indentifier;
        String packet=  indentifier.substring(0,5);
        System.out.println("packer :" + packet.trim());
        switch(packet.trim()){
            case "Voice":
                t = type.VOICE;
                break;
            case "Video":
                t = type.VIDEO;
                break;
            case "Data":
                t = type.DATA;
                break;
            default:
                System.out.println("error");
        }
    }
    public int getPriority(){
        switch(t){
            case VOICE:
                return 2;
            case VIDEO:
                return 1;
            case DATA:
                return 0;
            default:
                return -1;
        }
    }
}
