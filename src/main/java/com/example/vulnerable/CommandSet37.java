package com.example.vulnerable;

/**
 * Command Injection - Set 41-45
 */
public class CommandSet37 {
    
    public void vuln401(String v) throws Exception { Runtime.getRuntime().exec(v); }
    public void vuln402(String v) throws Exception { Runtime.getRuntime().exec("cat " + v); }
    public void vuln403(String v) throws Exception { Runtime.getRuntime().exec("ls " + v); }
    public void vuln404(String v) throws Exception { Runtime.getRuntime().exec("rm " + v); }
    public void vuln405(String v) throws Exception { Runtime.getRuntime().exec("mv " + v); }
    public void vuln406(String v) throws Exception { Runtime.getRuntime().exec("cp " + v); }
    public void vuln407(String v) throws Exception { Runtime.getRuntime().exec("mkdir " + v); }
    public void vuln408(String v) throws Exception { Runtime.getRuntime().exec("rmdir " + v); }
    public void vuln409(String v) throws Exception { Runtime.getRuntime().exec("touch " + v); }
    public void vuln410(String v) throws Exception { Runtime.getRuntime().exec("chmod " + v); }
    public void vuln411(String v) throws Exception { Runtime.getRuntime().exec("chown " + v); }
    public void vuln412(String v) throws Exception { Runtime.getRuntime().exec("grep " + v); }
    public void vuln413(String v) throws Exception { Runtime.getRuntime().exec("find " + v); }
    public void vuln414(String v) throws Exception { Runtime.getRuntime().exec("sed " + v); }
    public void vuln415(String v) throws Exception { Runtime.getRuntime().exec("awk " + v); }
    public void vuln416(String v) throws Exception { Runtime.getRuntime().exec("tail " + v); }
    public void vuln417(String v) throws Exception { Runtime.getRuntime().exec("head " + v); }
    public void vuln418(String v) throws Exception { Runtime.getRuntime().exec("wc " + v); }
    public void vuln419(String v) throws Exception { Runtime.getRuntime().exec("sort " + v); }
    public void vuln420(String v) throws Exception { Runtime.getRuntime().exec("uniq " + v); }
    public void vuln421(String v) throws Exception { Runtime.getRuntime().exec("diff " + v); }
    public void vuln422(String v) throws Exception { Runtime.getRuntime().exec("tar " + v); }
    public void vuln423(String v) throws Exception { Runtime.getRuntime().exec("zip " + v); }
    public void vuln424(String v) throws Exception { Runtime.getRuntime().exec("unzip " + v); }
    public void vuln425(String v) throws Exception { Runtime.getRuntime().exec("gzip " + v); }
    public void vuln426(String v) throws Exception { Runtime.getRuntime().exec("gunzip " + v); }
    public void vuln427(String v) throws Exception { Runtime.getRuntime().exec("wget " + v); }
    public void vuln428(String v) throws Exception { Runtime.getRuntime().exec("curl " + v); }
    public void vuln429(String v) throws Exception { Runtime.getRuntime().exec("ping " + v); }
    public void vuln430(String v) throws Exception { Runtime.getRuntime().exec("traceroute " + v); }
    public void vuln431(String v) throws Exception { Runtime.getRuntime().exec("netstat " + v); }
    public void vuln432(String v) throws Exception { Runtime.getRuntime().exec("ps " + v); }
    public void vuln433(String v) throws Exception { Runtime.getRuntime().exec("kill " + v); }
    public void vuln434(String v) throws Exception { Runtime.getRuntime().exec("killall " + v); }
    public void vuln435(String v) throws Exception { Runtime.getRuntime().exec("pkill " + v); }
    public void vuln436(String v) throws Exception { Runtime.getRuntime().exec("top " + v); }
    public void vuln437(String v) throws Exception { Runtime.getRuntime().exec("df " + v); }
    public void vuln438(String v) throws Exception { Runtime.getRuntime().exec("du " + v); }
    public void vuln439(String v) throws Exception { Runtime.getRuntime().exec("mount " + v); }
    public void vuln440(String v) throws Exception { Runtime.getRuntime().exec("umount " + v); }
    public void vuln441(String v) throws Exception { Runtime.getRuntime().exec("useradd " + v); }
    public void vuln442(String v) throws Exception { Runtime.getRuntime().exec("userdel " + v); }
    public void vuln443(String v) throws Exception { Runtime.getRuntime().exec("passwd " + v); }
    public void vuln444(String v) throws Exception { Runtime.getRuntime().exec("sudo " + v); }
    public void vuln445(String v) throws Exception { Runtime.getRuntime().exec("su " + v); }
    public void vuln446(String v) throws Exception { Runtime.getRuntime().exec("ssh " + v); }
    public void vuln447(String v) throws Exception { Runtime.getRuntime().exec("scp " + v); }
    public void vuln448(String v) throws Exception { Runtime.getRuntime().exec("rsync " + v); }
    public void vuln449(String v) throws Exception { Runtime.getRuntime().exec("systemctl " + v); }
    public void vuln450(String v) throws Exception { Runtime.getRuntime().exec("service " + v); }
}
