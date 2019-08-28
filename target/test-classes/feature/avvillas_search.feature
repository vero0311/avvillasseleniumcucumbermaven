Feature: liberty credit simulator
AS a Avvillas user
I want to complete the form
To calculate the liberty credit

  Scenario: Form with data not allowed
    Given That I am in Avvillas home page
    When I write in amount field  "43243" AND in term in month "34" AND in credit destination "Gastos Personales" and I do not choose any option in liberty agreement field
    Then I hope to see warning messages, "El monto mínimo permitido es $500.000" and "Campo Obligatorio"

