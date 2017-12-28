package day11;

/**
 * Calculate Santa's new password based off his current password
 * and a set of corporate policy rules
 */
public class Program
{
    public static void main(String[] args)
    {
        String currentPassword = "hepxcrrq";
        String newPassword = calculateNewPassword(currentPassword);
        System.out.println("Santa's new password is : " + newPassword);
    }

    public static String calculateNewPassword(String currentPassword)
    {
        do
        {
            currentPassword = incrementPassword(currentPassword);
        }
        while (!passwordMeetsRequirements(currentPassword));

        return currentPassword;
    }

    public static boolean passwordMeetsRequirements(String password)
    {
        if (passwordContainsStraight(password) &&
            !passwordContainsInvalidCharacters(password) &&
             passwordContainsTwoRepeatedPairs(password))
        {
            return true;
        }

        return false;
    }

    public static boolean passwordContainsStraight(String password)
    {
        for (int i = 0; i < password.length() - 2; i++)
        {
            if (password.charAt(i) == (char)(password.charAt(i + 1) - 1) &&
                password.charAt(i) == (char)(password.charAt(i + 2) - 2))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean passwordContainsInvalidCharacters(String password)
    {
        if (password.contains("i") || password.contains("l") || password.contains("o")) return true;
        return false;
    }

    public static boolean passwordContainsTwoRepeatedPairs(String password)
    {
        int duplicateCount = 0;
        char firstDuplicate = '\0';

        for (int i = 0; i < password.length() - 1; i++)
        {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) != firstDuplicate)
            {
                firstDuplicate = password.charAt(i);
                duplicateCount++;
                if (duplicateCount >= 2) break;

                i++;
            }
        }

        if (duplicateCount >= 2) return true;

        return false;
    }

    public static String incrementPassword(String currentPassword)
    {
        StringBuilder builder = new StringBuilder(currentPassword);
        for (int i = builder.length() - 1; i >= 0; i--)
        {
            if (builder.charAt(i) == 'z')
            {
                builder.setCharAt(i, 'a');
            }
            else
            {
                builder.setCharAt(i, (char)(builder.charAt(i) + 1));
                break;
            }
        }

        return builder.toString();
    }
}
