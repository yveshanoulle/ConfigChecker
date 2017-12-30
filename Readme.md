<H1>Config Checker</H1>

I prefer to configure my devices using configuration files I upload in a sourcecontrol system.
By doing that I have the advantage of a history of my changes.

I change them on my regular computer, upload them to my sourcecontrol system and download them on the device that needs the configuration. 
I use a script to do the download on the device. That script is adapted to the device or the software it configures.
The script does what needs to be done to restart the service with the new configuration. 
I don't do any manual configuration anymore on the devices. That way, the configuration changes are tracked. 

This approach has one drawback: when I screw up, it can be that the service tires to restart and does not restart because of a bad configuration.
I had this problem some time ago with the DHCP service hosted on a raspberyy PI. 
A lack of a closing } gave me all kind of network problems. 

That made me decide I wanted to have a small tool that I could feed a configuration file and it would tell me if it was ok to upload it to sourcecontrol. 

The first version of this tool; only checks DHCP files, the idea is to add more types of configuration. 
As it's an MVP, the tool is very strict on what is allowed. F.ex. it expects { and } to be alone on a line. 
That is technically stricter then what the DHCP tool allows, yet that makes it a lot easier to locate the problems. 

At this moment the project only tests file in project mode. 
In the future version, this will be a command line tool. 
The tool will returns TRUE if everything is fine; It will returns FALSE when the file is NOT OK.  

