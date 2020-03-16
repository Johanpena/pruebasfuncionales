Feature: Autenticar un usuario
    Como usuario de la aplicacion
    Deseo iniciar sesion usando mis credenciales
    Para acceder a las opciones que se presentan

    Background: El usuario navega en la pagina de inicio de la aplicacion
      Given me encuentro en la pagina de inicio

     @escenario1
	Scenario Outline: autenticacion exitosa
       When ingreso las credenciales <usuario> y el <password>
       Then puedo ver el perfil del usuario <perfil> y la cedula queda registrada con <documento>

	Examples:
		|usuario |password|perfil|documento|
        |rap@yopmail.com|12345|rap@yopmail.com|152675126187|

  @escenario6
  Scenario Outline: autenticacion sin permiso de solicitudes
      When ingreso las credenciales <usuario> y el <password>
      Then generar mensaje error <mensaje>

    Examples:
      |usuario |password|mensaje|
        |prueba12020@yopmail.com|12345|Inicio de sesión fallido! Por favor verifica tu usuario y contraseña.|

  @escenario4
  Scenario Outline: autenticacion fallida por filtrado de ip sospechosa
    When envio la ip sospechosa
    And ingreso las credenciales <usuario> y el <password>
    Then generar mensaje error <mensaje>
    Examples:
      |usuario |password|mensaje|
      |rap@yopmail.com|12345|Inicio de sesión fallido! Por favor verifica tu usuario y contraseña.|


  @escenario2
  Scenario Outline: autenticacion fallida por falta de permisos a la aplicacion.
    When ingreso las credenciales <usuario> y el <password>
    Then generar mensaje error <mensaje>
    Examples:
      |usuario |password|mensaje|
      |prueba1@yopmail.com|12345|Inicio de sesión fallido! Por favor verifica tu usuario y contraseña.|

