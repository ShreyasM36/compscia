import pandas as pd

# Read the CSV file and convert it into a DataFrame
df = pd.read_csv('data.csv')

# Convert the DataFrame to a numPy array
csv_array = df.to_numpy()

# Get user input for the name of the row to compare with answer row (case-insensitive)
specified_row_name = input("Enter the name in the csv file to report on: ")

# Find the index of the specified row (case-insensitive)
specified_row_index = df.index[df['Name'].str.lower() == specified_row_name.lower()].tolist()

# If the person is not in the csv file, output an error message; otherwise, print out the row it is contained in.
if not specified_row_index:
    print(f"Row with name '{specified_row_name}' not found.")
else:
    specified_row_index = specified_row_index[0]

    # Select the specified row
    specified_row = csv_array[specified_row_index]

    # Initialize a dictionary to store counts for each column
    column_value_counts = {}

    # Iterate over each column from column 4 onwards (first few columns are not questions but information on the tester)
    for column_index, column_values in enumerate(csv_array.T[4:]):
        # Initialize a dictionary to count occurrences of each unique value in the column
        value_counts = {}

        for row_index, value in enumerate(column_values):
            # Skip the value if it is correct
            if row_index == specified_row_index:
                continue

            # Convert both values to strings before comparison
            str_value = str(value)
            str_specified_row_value = str(specified_row[column_index + 4])  # Adjust the column index due to not needing the first 4 rows

            # Compare with the specified row
            if str_value != str_specified_row_value and isinstance(value, str):
                # Increment the counter
                value_counts[str_value] = value_counts.get(str_value, 0) + 1

        # Line is unnecessary, just copied from GroupFeedback, instead of changing the thinking it is just using the same thinking for 1 person.
        least_common_value = min(value_counts, key=value_counts.get, default=None)

        # Store the wrong answers for each column in the dictionary
        column_value_counts[df.columns[column_index + 4]] = least_common_value

    # Display the wrong answers for each question
    print("Wrong Answers for each question:")
    for column, value in column_value_counts.items():
        print(f"{column}: {value}")

# Open the file in append mode and write the results
with open('ininfo.txt', 'a') as file:
    # Append the wrong answers for each question to the file
    for column, least_common_value in column_value_counts.items():
        file.write(f"{specified_row_name} answered this wrong: {column}: {least_common_value}\n")

#download the txt file
urllib.request.urlretrieve('C:\Users\shrey\IdeaProjects\testing', 'downloaded_ininfo.txt')
print("ininfo.txt downloaded successfully.")