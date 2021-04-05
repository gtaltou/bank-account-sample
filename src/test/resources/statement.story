Given: A customer makes

           a deposit    of 3000 $ on 01-01-2021
       And a deposit    of 4000 $ on 15-03-2021
       And a deposit    of 5000 $ on 20-03-2021
       And a deposit    of 1000 $ on 23-03-2021
       And a withdrawal of 1000 $ on 25-03-2021
       And a withdrawal of 2000 $ on 30-03-2021

When   he prints his bank statement

Then   he would see

date       || credit   || debit    || balance
30/03/2021 ||          || 2000,00  || 10000,00
25/03/2021 ||          || 1000,00  || 12000,00
23/03/2021 || 1000,00  ||          || 13000,00
20/03/2021 || 5000,00  ||          || 12000,00
15/03/2021 || 4000,00  ||          || 7000,00
01/03/2021 || 3000,00  ||          || 3000,00

