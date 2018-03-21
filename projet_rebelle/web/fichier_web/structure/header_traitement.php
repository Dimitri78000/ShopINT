<?php
session_start();
try
{
	//$bdd = new PDO('mysql:host=sql200.byethost.com;dbname=b7_21575186_main_database;charset=utf8', 'b7_21575186', 'AlDaHuLeLeLoTe', array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
	$bdd = new PDO('mysql:host=localhost;dbname=b7_21575186_main_database;charset=utf8', 'root', '', array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
}
catch(Exception $e)
{
        die('Erreur : '.$e->getMessage());
}
?>

<?php include('../fichier_style/style.php'); ?>