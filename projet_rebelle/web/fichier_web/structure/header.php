<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">

		<!-- Style ne fonctionne pas -->
		<!-- <link rel="stylesheet" href="fichier_style/style.css" /> --> 
		<!-- Le fichier style.css ne fonctionne pas, on utilise donc un fichier style.php -->
		<?php include('fichier_style/style.php'); ?>
		
		<!-- Favicon -->
		<link rel="apple-touch-icon" sizes="57x57" href="contenu_multimedia/favicon/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="contenu_multimedia/favicon/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="contenu_multimedia/favicon/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="contenu_multimedia/favicon/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="contenu_multimedia/favicon/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="contenu_multimedia/favicon/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="contenu_multimedia/favicon/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="contenu_multimedia/favicon/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="contenu_multimedia/favicon/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="contenu_multimedia/favicon/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="contenu_multimedia/favicon/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="contenu_multimedia/favicon/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="contenu_multimedia/favicon/favicon-16x16.png">
		<link rel="manifest" href="contenu_multimedia/favicon/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="contenu_multimedia/favicon/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">



		<title> ShopINT - Carrefour Evry </title>
	</head>

	<!-- Connexion à la base de donnée -->
<?php
session_start();
try
{
	$bdd = new PDO('mysql:host=localhost;dbname=b7_21575186_main_database;charset=utf8', 'root', '');
	//$bdd = new PDO('mysql:host=sql200.byethost.com;dbname=b7_21575186_main_database;charset=utf8', 'b7_21575186', 'AlDaHuLeLeLoTe');
}
catch (Exception $e)
{
        die('Erreur : ' . $e->getMessage());
}
?>

<body> 

	<header>

		<center> <truc class="menu_header">
			<a  class="onglet_header" href="index.php"> <img class="image_header" src="contenu_multimedia/image/header_image.jpg" /> </a> <a class="espace"> :) </a>              
				<a class="onglet_header" href="connexion.php"> Connexion </a> <a class="espace"> :) </a>   
				<a class="onglet_header" href="course.php"> Course </a> <a class="espace"> :) </a>               
				<a class="onglet_header" href="plan.php"> Plan </a>    <a class="espace"> :) </a>                  
				<a class="onglet_header" href="recherche.php">  <img class="image_header" src="contenu_multimedia/image/loupe.jpg" /> </a> 

			<!-- STYLE DEBUT -->       
			<style> 
			.image_header{ vertical-align: bottom;}
			.menu_header{
				font-size : 2.1em;
				text-align : center;
			 	border: 2px black solid;
			 	border-radius: 4px;
				padding: 5px 20px 5px 20px;
				margin: 0px 20px 0px 20px;
			}
			.espace { color: rgba(0,0,0,0);}
			.onglet_header { text-decoration: none; }


			</style> 
			<!-- STYLE FIN -->

		</center></truc>  
 
	</header> 




