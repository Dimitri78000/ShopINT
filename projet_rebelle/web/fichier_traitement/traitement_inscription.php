<?php include('../fichier_web/structure/header_traitement.php');  ?>




<?php
$page = $_SERVER["HTTP_REFERER"];
header('Refresh:1; URL='.$page);
?>