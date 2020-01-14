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
    Given  me encuentro en la pagina de inicio
    Then valido que me encuentro en la pagina de registro

    # Pasos:
      # Given: Describe un contexto inicial
      # When: Describe un evento
      # Then: Describe un resultado esperado
      # And, But conectores

    # Se recomienda que cada escenario tenga de 3 a 5 pasos
  Scenario Outline: Solicitud de credito - Cliente no registrado
    When ingreso las credenciales para la prueba
      |<nombre1>|<nombre2>|<apellido1>|<apellido2>|<tipo_documento>|<documento>|<correo>|<celular>|<password>|<password2>|<ciudad>|<direccion>|<tipo_vivienda>|<tiempo_vivienda>|<genero>|<fecha_naci>|<estado_civil>|<personas_cargo>|<numero_hijos>|<f_expedi>|<nivel_estu>|<estado_estudio>|
    Then puedo ver que se ha creado la solicitud de credito de forma exitosa

#	Scenario: autenticacion fallida
#      When ingreso el nombre de "usuario"
#      And el "password"
#      Then aparece un "mensaje" informativo
#      	|mensaje|
#      	|hola2  |

    Examples:
      |nombre1|nombre2|apellido1|apellido2|tipo_documento|documento|correo|celular|password|password2|ciudad|direccion|tipo_vivienda|tiempo_vivienda|genero|fecha_naci|estado_civil|personas_cargo|numero_hijos|f_expedi|nivel_estu|estado_estudio|

      |juan|david|marin|lopez|1|879654423|juandm@yopmail.com|3785874788|12345|12345|1|calle 33|2|3|1|30/08/1988|1|0|0|05/06/2006|5|1|




  Scenario Outline: registro informacion_basica
    When ingreso las credenciales para la prueba2
      |<ciudad>|<direccion>|<tipo_vivienda>|<tiempo_vivienda>|<genero>|<fecha_naci>|<estado_civil>|<personas_cargo>|<numero_hijos>|<f_expedi>|<nivel_estu>|<estado_estudio>|
    Then puedo ver el usuario creado <Referencia_Personal>

    Examples:
      |ciudad|direccion|tipo_vivienda|tiempo_vivienda|genero|fecha_naci|estado_civil|personas_cargo|numero_hijos|f_expedi|nivel_estu|estado_estudio|
      |juan|david|marin|lopez|1|879654423|juandm@yopmail.com|3785874788|12345|12345|

