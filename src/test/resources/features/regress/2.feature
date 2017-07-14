#language: en
Feature: Add new beneficiary

  @regress
  @2
  Scenario Outline: Add new beneficiary. With Mobile and Email. [To myself]
    * page is being opened "Tutorial Page"
    * user (click the button) "Skip"
    * page is being opened "Authorization Page"
    * user (fill the field) "PhoneNumber" "662266"
    * user (click the button) "Next"
    * page is being opened "PinCode Page"
    * user (entering passcode) "1111"
    * page is being opened "Main Activity"
    * user (click the button) "Purple Transfer"
    * user (choosing transfer type) "To bank account"
    * user (click the button) "Skip"
    * page is being opened "Bank Transfer"
    * user (click the button) "Add a new beneficiary"
    * page is being opened "Choose transfer type"
    * user (click the button) "To myself"
    * user (click the button) "Next"
    * page is being opened "Choose country and currency"
    * user (choosing country) "<Country>"
    * user (choosing currency) "<Currency>"
    * user (click the button) "Next"
    * page is being opened "Fill into account details"
    * user (fill the field) "Legal first name" "<Name>"
    * user (fill the field) "Legal last name" "<Last Name>"
    * user (fill the field) "IBAN/Account number" "<IBAN>"
    * user (fill the field) "BIC/SWIFT" "<BIC>"
    * user (fill the field) "Mobile phone (optional)" "<Mobile>"
    * user (fill the field) "E-mail (optional)" "<E-mail>"
    * user (save temp values to stash) data
      | Legal first name    |
      | Legal last name     |
      | IBAN/Account number |
    * user (click the button) "Next"
    * page is being opened "Operation State"
    * user (checking that beneficiary) "successfully created"
    * user (click the button) "Done"
    * page is being opened "Bank Transfer"
    * user (checking that new beneficiary appear in list of beneficiaries)

    Examples:
      | Country | Currency        | Name      | Last Name      | IBAN                     | BIC         | Mobile       | E-mail          |
      | Austria | Euro            | Test Name | Test last Name | AT61 1904 3002 3457 3201 | RLBBAT2E028 | 79117556228  | g@google.com    |
      | Norway  | Norwegian Krona | Artem     | Sokovets       | NO93 8601 1117 947       | LABANOKK    | +38011123333 | _like@yandex.ru |