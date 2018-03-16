<?php
session_start();
try
{
	$bdd = new PDO('mysql:host=sql200.byethost.com;dbname=b7_21575186_main_database;charset=utf8', 'b7_21575186', 'AlDaHuLeLeLoTe', array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
	//$bdd = new PDO('mysql:host=localhost;dbname=b7_21575186_main_database;charset=utf8', 'root', '', array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
}
catch(Exception $e)
{
        die('Erreur : '.$e->getMessage());
}


$Nom_rayon = $_POST['Nom_rayon_form']; 
$X0 = $_POST['X0_form']; 
$Y0 = $_POST['Y0_form']; 
$X1 = $_POST['X1_form']; 
$Y1 = $_POST['Y1_form']; 

echo "Traitement"; 

$req = $bdd->prepare('INSERT INTO table_petit_magasin(Nom_rayon, X0, Y0, X1, Y1) VALUES(?, ?, ?, ?, ?)');


$req->execute(array($Nom_rayon, $X0, $Y0, $X1, $Y1)); 


echo "Ok"; 

?>
<a class="onglet_header" href="../plan.php"> Plan </a>    <a class="espace"> :) </a>

 