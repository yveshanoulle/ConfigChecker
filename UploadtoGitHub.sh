
var="$(java  -jar configChecker.jar  dhcpunOneClosingParentheseMissing.conf)";
if test “$var” = “true” ; then
	echo
	echo “Config file is OK, uploading it to github…”
	echo
else
	echo
	echo Config file contains errors. Did not upload it to github.
	echo
fi

