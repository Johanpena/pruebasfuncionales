# Definici�n de la historia de usuario que creo negocio
Feature: creacion cliente
  Como usuario de la aplicacion
  Deseo crearme como cliente

  # Recuerde que las palabras clave son:
    # Feature
    # Example (Scenario y Scenario Outline)
    # Given, When, Then, And, But (pasos)
    # Background
    # Combinations

   # El Background se utiliza cuando en diferentes escenarios se tienen las mismas precondiciones
  Background: El usuario navega en la pagina de inicio de la aplicacion
    Given me encuentro en la pagina de inicio
    Then valido que me encuentro en la pagina de registro

    # Pasos:
      # Given: Describe un contexto inicial
      # When: Describe un evento
      # Then: Describe un resultado esperado
      # And, But conectores

    # Se recomienda que cada escenario tenga de 3 a 5 pasos
  Scenario Outline: registro credenciales
    When ingreso las credenciales <nombre1> , <nombre2> , <apellido1>,<apellido2>,<tipo_documento> , <documento>, <correo> , <celular> , <contraseña> , confirmar_contras>
    Then puedo ver el usuario creado <Informacion_basica>

#	Scenario: autenticacion fallida
#      When ingreso el nombre de "usuario"
#      And el "password"
#      Then aparece un "mensaje" informativo
#      	|mensaje|
#      	|hola2  |

    Examples:
      |nombre1|nombre2|apellido1|apellido2|tipo_documento|documento|correo|celular|password|password2|
      |juan|david|marin|lopez|0|879654422|juandm@yopmail.com|3785874788|12345|12345|

