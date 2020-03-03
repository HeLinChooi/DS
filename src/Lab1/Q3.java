package Lab1;

public class Q3 {

    private String name, ip, sm;
    private boolean status;

    public Q3(String name, String ip, String sm, boolean status) {
        this.name = name;
        this.ip = ip;
        this.sm = sm;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getSm() {
        return sm;
    }

    public boolean isStatus() {
        return status;
    }
    
    public String Pingable(Q3 o) {
        if(!o.isStatus()){
            return this.name + " cannot ping " + o.getName() + " because "
                    + "the destination " + o.getName() + " is down.";
        }
        String[] ips = this.ip.split("\\.");
        String[] ips2 = o.ip.split("\\.");
        String[] sm = this.sm.split("\\.");
        String[] sm2 = o.sm.split("\\.");
        for (int i = 0; i < ips.length; i++) {
            if ((Integer.parseInt(ips[i]) & Integer.parseInt(sm[i]))
                    != (Integer.parseInt(ips2[i]) & Integer.parseInt(sm2[i]))) {
                return this.name + " cannot ping " + o.getName()
                        + " because "
                    + "the destination " + o.getName() + " is "
                        + "located in different network.";
            }
        }
        return this.name + " can ping " + o.getName();
    }
}
