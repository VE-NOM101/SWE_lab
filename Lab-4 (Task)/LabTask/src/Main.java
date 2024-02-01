//Roll:2007101

/*
Here, I am using two design patterns.
A bridge design pattern is used to bridge or link remotes and TVs. This allows you to add a new TV or new link without any conflict.
A proxy design pattern is used to run YouTube. Youtube is an app, so to boost memory usage, it can be used.
*/
interface TV{
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int vol);

    int getChannel();

    void setChannel(int channel);

    //This Youtube interface method has been added to implement Proxy Design pattern while Smart
    //remote calls the showYoutube() method.Here loading of the youtube will execute for the very first time
    //Rest of the time it won't be loaded.
    void Youtube(YoutubeClass yt);

}

class SmartTV implements TV{
    boolean powerOn=false;
    int volume=40;
    int channel=1;

    @Override
    public boolean isEnabled() {
        return powerOn;
    }

    @Override
    public void enable() {
        powerOn=true;
    }

    @Override
    public void disable() {
        powerOn=false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        volume=vol;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
    @Override
    public void Youtube(YoutubeClass yt){
        System.out.println("Youtube for SmartTV::");
        yt.runYoutube();
    }
}

class GeneralTV implements TV{
    boolean powerOn=false;
    int volume=20;
    int channel=1;

    @Override
    public boolean isEnabled() {
        return powerOn;
    }

    @Override
    public void enable() {
        powerOn=true;
    }

    @Override
    public void disable() {
        powerOn=false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        volume=vol;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
    @Override
    public void Youtube(YoutubeClass yt){
        System.out.println("Youtube for GeneralTV::");
        yt.runYoutube();
    }
}


class Remote{
    protected TV tv;

    Remote(){tv=null;}
    Remote(TV tv){
        this.tv=tv;
    }
    public void togglePower() {
        if(tv.isEnabled()){
            tv.disable();
            System.out.println("Power turned off");
        }
        else {
            tv.enable();
            System.out.println("Power turned on");
        }
    }

    public void volumeUp() {
        if(tv.isEnabled()){
            tv.setVolume(tv.getVolume()+5);
            System.out.println("Increasing volume +5");
        }else{
            System.out.println("Please Turn on tv first");
        }
    }

    public void volumeDown() {
        if(tv.isEnabled()){
            tv.setVolume(tv.getVolume()-5);
            System.out.println("Decreasing volume -5");
        }else{
            System.out.println("Please Turn on tv first");
        }

    }

    public void channelUp() {
        if(tv.isEnabled()){
            tv.setChannel(tv.getVolume()+1);
            System.out.println("Channel +1");
        }else{
            System.out.println("Please Turn on tv first");
        }


    }

    public void channelDown() {
        if(tv.isEnabled()){
            tv.setChannel(tv.getVolume()-1);
            System.out.println("Channel -1");
        }else{
            System.out.println("Please Turn on tv first");
        }

    }
}

class SmartRemote extends Remote{

    SmartRemote(){

    }
    SmartRemote(TV tv){
        super(tv);
    }
    void showYoutube(YoutubeClass yt){
        tv.Youtube(yt);
    }
}

//YoutubeCLass is used to implement Proxy Design method
interface YoutubeClass{
    void runYoutube();
}
class FirstLoadYoutube implements YoutubeClass{

    @Override
    public void runYoutube() {
        System.out.println("->Running Youtube");
    }
}

class proxyLoadYoutube implements YoutubeClass{
    private FirstLoadYoutube firstLoadYoutube;
    @Override
    public void runYoutube() {
        if(firstLoadYoutube==null){
            firstLoadYoutube=new FirstLoadYoutube();
            System.out.println("->Starting Youtube");
        }
        firstLoadYoutube.runYoutube();
    }
}

public class Main {
    public static void main(String[] args) {


        GeneralTV gtv=new GeneralTV();
        SmartTV stv=new SmartTV();
        Remote remote= new Remote(gtv);
        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();
        remote.channelDown();
        remote.volumeDown();


        SmartRemote sremote= new SmartRemote(gtv);
        sremote.togglePower();
        sremote.volumeUp();
        sremote.channelUp();
        sremote.channelDown();
        sremote.volumeDown();


        YoutubeClass yt=new proxyLoadYoutube();

        //Accessing Youtube() using smart-remote.
        sremote.showYoutube(yt);
        sremote.showYoutube(yt);
        //Direct accessing Youtube().
        gtv.Youtube(yt);
    }

}