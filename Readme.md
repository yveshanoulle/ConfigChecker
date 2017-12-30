<H1>Config Checker</H1>

As much as I like DHCP for new devices, it's important in my network that some devices have a fixed IP adres.
I prefer to configure the IP of these devices using a central DHCP configuration file.
As a developer I prefer to have everything in a sourcecontrol system.
By adding this config file to a source control system;  I have the advantage of a history of my changes.

I change them on my regular computer, upload them to my sourcecontrol system and download them on the device that needs the configuration. 
I use a script to do the download on the device. That script is adapted to the device or the software it configures.
The script does what needs to be done to restart the service with the new configuration. 
I don't do any manual configuration anymore on the devices. That way, the configuration changes are tracked. 

This approach has one drawback: when I screw up, it can be that the service tries to restart and does not restart because of a bad configuration.
I had this problem some time ago with the DHCP service hosted on a raspberyy PI. 
A lack of a closing } gave me all kind of network problems. 

That made me decide I wanted to have a small tool that I could feed a configuration file and it would tell me if it was ok to upload it to sourcecontrol. 

The current version of this tool, only checks DHCP files, the idea is to add more types of configuration.
As it's an MVP, the tool is very strict on what is allowed. F.ex. it expects { and } to be alone on a line. 
That is technically stricter then what the DHCP tool allows, yet that makes it a lot easier to locate the problems. 

The tool will returns true if everything is fine; It will returns false when the file is NOT OK.

See the ExampleUploadtoGitHub.sh for an example on how to use the configChecker.




