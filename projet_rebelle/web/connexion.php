<?php include('fichier_web/structure/header.php'); ?>
<a class="titre_partie"><li> Partie Connexion et inscription, ou profil </li> </a>  <br/>  

<?php 
if (!isset($_POST['pseudo'])) //On est dans la page de formulaire
{ ?>
	<form method="post" action="fichier_traitement/traitement_connexion.php">
		<fieldset class="fieldset_connexion">
		<legend>Connexion</legend>
		<p>
			<label for="pseudo">Pseudo :</label><input name="pseudo" type="text" id="pseudo" /><br />
			<label for="password">Mot de Passe :</label><input type="password" name="password" id="password" />
		</p>
		
		<p>
			<input type="submit" value="Connexion" />
		</p>
		</fieldset>
	</form>
	<style>
	.fieldset_connexion{
	max-width: 700px;
	margin-left: auto;
    margin-right: auto;
	}
	</style>
	<br/><center> <a href="./deconnexion.php">Deconnexion </a> </center><br/>

	<form method="post" action="fichier_traitement/traitement_inscription.php">
		<fieldset class="fieldset_inscription">
		<legend>Inscription</legend>
		<p>
			<label for="pseudo">Pseudo :</label><input name="pseudo" type="text" id="pseudo" /><br />
			<label for="password">Mot de Passe :</label><input type="password" name="password" id="password" /> <br/> <br/>
			-- Facultatif : -- <br/>
			<label for="mail"> Mail: </label><input type="email" name="mail" id="mail" /> Pour réinitialiser mot de passe si oublié <br/>
			<label for="password_admin"> PassAdmin: </label><input type="password" name="password_admin" id="password_admin" />

		</p>
		
		<p>
			<input type="submit" value="Inscription" />
		</p>
		</fieldset>
	</form>
	<style>
	.fieldset_inscription{
	max-width: 700px;
	margin-left: auto;
    margin-right: auto;
	}
	</style>

<?php
} else { ?>




<?php } ?>

<?php include('fichier_web/structure/footer.php'); ?>