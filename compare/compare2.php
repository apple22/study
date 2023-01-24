<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php
echo "1!=2 : ";
var_dump(1!=2); #true
echo '<br />'; 
echo "1!=1 : ";
var_dump(1!=1); #false
echo "<br />";
echo '"one"!="two" : '; #true
echo '<br/>';
echo '"one" != "one" :';
var_dump("one" != "one"); #false
echo '<br />';
?>
</body>
</html>