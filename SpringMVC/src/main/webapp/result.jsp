<!--<%@page language ="java"%>-->

<html>
	
    <!--If you have css code use it to display neat-->
    <!--<head>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>-->
	
	<!--when ever we want to write java code in jsp we need to use write in this tag <% %>-->
	
    <body>
		
    <!--	<h2>Result is :<%= session.getAttribute("result") %> ></h2> -->
		<!--this is one way session.getAttribute("result") %>
				 we can do it using JSTL library tags 
				 ${result} we should mention $ to say its jstl tag
				-->
				
	<!--	<h2>Result is : ${result}</h2>			-->
		<h2>Alien Object cointain: ${alien}</h2>
			
		
    </body>
</html>

