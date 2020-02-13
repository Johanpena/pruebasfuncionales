Feature: Autenticar un usuario
    Como usuario de la aplicacion
    Deseo iniciar sesion usando mis credenciales
    Para acceder a las opciones que se presentan

    Background: El usuario navega en la pagina de inicio de la aplicacion
      Given me encuentro en la pagina de inicio
    Then debo encontrar la seccion para iniciar sesion

     @escenario1
	Scenario Outline: autenticacion exitosa
      When ingreso las credenciales <usuario> y el <password>
      Then puedo ver el perfil del usuario <perfil>

	Examples:
		|usuario |password|perfil|
        |mariod@yopmail.com|12345|MARIO DUQUE|

       @escenario2
  Scenario Outline: autenticacion sin permiso de ingreso
    When ingreso las credenciales <usuario> y el <password>
    Then retorno a la pagina de inicio

    Examples:
      |usuario |password|
      |mateoc@yopmail.com|12345|


@escenario3
  Scenario Outline: autenticacion permiso denegado
    When ingreso las credenciales <usuario> y el <password>
    Then generar mensaje error <mensaje>

    Examples:
      |usuario |password|mensaje|
      |mateoc@yopmail.com|123456|Inicio de sesión fallido! Por favor verifica tu usuario y contraseña e intenta nuevamente|


  @escenario4
  Scenario Outline: validar ip sospechosa
    When envio la ip sospechosa
    Then rechazar ingreso a la aplicacion <ipsospechosa>

    Examples:
      |ipsospechosa|
      |192.82.01.51|