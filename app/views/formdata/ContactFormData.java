package views.formdata;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * A backing class for the new contact form.
 */
public class ContactFormData {

  private static final int DIGIT_LENGTH = 12;
  private static final int ADDRESS_LENGTH = 24;

  /** The first name field. */
  public String firstName = "";

  /** The last name field. */
  public String lastName = "";

  /** The telephone number field. */
  public String telephone = "";

  /** The address text field. */
  public String address = "";




  /**
   * Ensure appropriate input is entered into the New Contact form.
   * @return A list of validation errors, if any.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First Name cannot be blank."));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last Name cannot be blank."));
    }

    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Digits cannot be blank."));
    }

    if (telephone.length() != DIGIT_LENGTH) {
      errors.add(new ValidationError("telephone", "Digits must follow the format xxx-xxx-xxxx."));
    }

    if (address == null || address.length() == 0) {
      errors.add(new ValidationError("address", "Address cannot be blank."));
    }

    if (address.length() <= ADDRESS_LENGTH) {
      errors.add(new ValidationError("address", "Address must be at least 24 characters long"));
    }

    return errors.isEmpty() ? null : errors;
  }


}
