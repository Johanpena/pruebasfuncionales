Feature: Solicitar Credito usuario recurrente
    Como usuario de la aplicacion
    Deseo realizar solicitud de credito

  
    Background: El usuario navega en la pagina de inicio de la aplicacion
      Given me encuentro en la pagina de miscreditos ingresando usuario <usuario> y contraseña <password>


     @escenario1
	Scenario Outline: solicitud de credito aprobado
      When solicito credito desde mis creditos ingresando usuario <usuario> y contraseña <password>
      Then verifico que la solicitud es aprobada
       Then verifico que puedo firmar

	Examples:
		|usuario |password|
        |mariod@yopmail.com|12345|
