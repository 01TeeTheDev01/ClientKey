package com.client.classes;

import com.client.data.CustomerKeysList;

import java.time.LocalDate;

public class Customer
{
    private String firstName, middleName, lastName;
    private LocalDate dateOfBirth;
    private boolean isDateOfBirthValid;
    private int age;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public boolean isDateOfBirthValid() {
        return isDateOfBirthValid;
    }
    public void setDateOfBirthValid(boolean dateOfBirthValid) { isDateOfBirthValid = dateOfBirthValid; }


    @Override
    public String toString()
    {
        String output = null, key = null;

        String tempKey = getLastName().substring(0,5);

        int remainChars = getLastName().length() - tempKey.length();

        if (remainChars > 0)
        {
            key = String.format("%s%s", tempKey, remainChars);

            switch (age)
            {
                case 0:
                    if (middleName.isBlank())
                        output = String.format("| %s | %s | %s | %s |%n" , key, getLastName(), getFirstName(), getDateOfBirth());
                    else
                        output = String.format("| %s | %s | %s | %s | %s |", key, getLastName(), getMiddleName(), getFirstName(), getDateOfBirth());
                    break;

                case 1:
                    if (middleName.isBlank())
                        output =  String.format("| %s | %s | %s | %s | %syr old |", key, getLastName(), getFirstName(), getDateOfBirth(), getAge());
                    break;

                default:
                    if (dateOfBirth != null)
                    {
                        if (middleName.isBlank())
                            output = String.format("| %s | %s | %s | %s | %syrs old |", key, getLastName(), getFirstName(), getDateOfBirth(), getAge());
                        else
                            output = String.format("| %s | %s | %s | %s | %s | %syrs old |", key, getLastName(), getMiddleName(), getFirstName(), getDateOfBirth(), getAge());
                    }
                    else
                    {
                        if (middleName.isBlank())
                            output = String.format("| %s | %s | %s | %syrs old |", key, getLastName(), getFirstName(), getDateOfBirth());
                        else
                            output = String.format("| %s | %s | %s | %s | %syrs old |", key, getLastName(), getMiddleName(), getFirstName(), getDateOfBirth());
                    }

                    break;
            }
        }
        else
        {
            key = String.format("%s", tempKey);

            switch (age)
            {
                case 0:
                    if (middleName.isBlank())
                        output = String.format("| %s | %s | %s | %s |%n" , key, getLastName(), getFirstName(), getDateOfBirth());
                    else
                        output = String.format("| %s | %s | %s | %s | %s |", key, getLastName(), getMiddleName(), getFirstName(), getDateOfBirth());
                    break;

                case 1:
                    if (middleName.isBlank())
                        output =  String.format("| %s | %s | %s | %s | %syr old |", key, getLastName(), getFirstName(), getDateOfBirth(), getAge());
                    break;

                default:
                    if (dateOfBirth != null)
                    {
                        if (middleName.isBlank())
                            output = String.format("| %s | %s | %s | %s | %syrs old |", key, getLastName(), getFirstName(), getDateOfBirth(), getAge());
                        else
                            output = String.format("| %s | %s | %s | %s | %s | %syrs old |", key, getLastName(), getMiddleName(), getFirstName(), getDateOfBirth(), getAge());
                    }
                    else
                    {
                        if (middleName.isBlank())
                            output = String.format("| %s | %s | %s | %syrs old |", key, getLastName(), getFirstName(), getDateOfBirth());
                        else
                            output = String.format("| %s | %s | %s | %s | %syrs old |", key, getLastName(), getMiddleName(), getFirstName(), getDateOfBirth());
                    }

                    break;
            }
        }

        CustomerKeysList.addCustomerKey(key);

        return output;
    }
}
