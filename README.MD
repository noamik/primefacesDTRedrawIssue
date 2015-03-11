= PrimeFaces 5.1 DataTable redraw issue on viewport resize =

To run the demo build the war file with

    % mvn package -P production

or import maven project into your IDE and deploy to application server from there.

Deployment tested with wildfly 8.2.0 Final. Most other application servers should do as well.

If deployment is successful point your browser to: http://localhost:8080/TestPrimefaces/ (adjust server name and port to your environment). You will see some useless scrollbars on north, south and center pane. Ignore those, they are an issue on their own. If you start resizing the browser window, you will see the table lag behind never rendering properly to the expected size. If you reload the page, everything fits nice (except for those additional scrollbars). The problem can be observed in both major browsers (Chrome and Firefox).

The problem remains if one doesn't use a template: http://localhost:8080/TestPrimefaces/index2.xhtml and can even be observed in a single div with absolute position: http://localhost:8080/TestPrimefaces/index3.xhtml