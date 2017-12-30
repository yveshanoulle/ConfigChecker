var=“$(java  -jar configChecker.jar dhcp/dhcpd.conf)”;

if test $var = “true” ; then
	echo
	echo “Config file is OK, uploading it to github…”
	echo

	git add .
	git commit -m "uploading after verifying dhcpd.conf file"
	git push

else
	echo
	echo Config file contains errors. Did not upload it to github.
	echo

	cp dhcp/dhcpd.conf ../ConfigChecker2/src/test/resources/
fi

