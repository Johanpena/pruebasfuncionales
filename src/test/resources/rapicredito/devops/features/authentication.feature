# Definici�n de la historia de usuario que creo negocio
Feature: Autenticar un usuario
    Como usuario de la aplicacion
    Deseo iniciar sesion usando mis credenciales
    Para acceder a las opciones que se presentan

  # Recuerde que las palabras clave son:
    # Feature
    # Example (Scenario y Scenario Outline)
    # Given, When, Then, And, But (pasos)
    # Background
    # Combinations

   # El Background se utiliza cuando en diferentes escenarios se tienen las mismas precondiciones
    Background: El usuario navega en la pagina de inicio de la aplicacion
      Given me encuentro en la pagina de inicio
      Then debo encontrar la seccion para iniciar sesion

    # Pasos:
      # Given: Describe un contexto inicial
      # When: Describe un evento
      # Then: Describe un resultado esperado
      # And, But conectores

    # Se recomienda que cada escenario tenga de 3 a 5 pasos
	Scenario Outline: autenticacion exitosa
      When ingreso las credenciales <usuario> y el <password>
      Then puedo ver el perfil del usuario <perfil>

#	Scenario: autenticacion fallida
#      When ingreso el nombre de "usuario"
#      And el "password"
#      Then aparece un "mensaje" informativo
#      	|mensaje|
#      	|hola2  |

	Examples:
		|usuario |password|perfil					   |
     	|mariod@yopmail.com|12345|MARIO DUQUE|



