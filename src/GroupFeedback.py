import pandas as pd

# read CSV file and convert it into a DataFrame
df = pd.read_csv('data.csv')

# convert the DataFrame into a NumPy array
csv_array = df.to_numpy()

# Row 2 is the model answer that the other responses will be compared to
row_2_index = 1
row_2 = csv_array[row_2_index]

# Initialize a dictionary to store counts for each column
column_value_counts = {}

# Iterate over each column from column 4 onwards (column 1-4 is useless data)
for column_index, column_values in enumerate(csv_array.T[4:]):
    # Initialize a dictionary to count occurrences of each unique value in the column
    value_counts = {}

    for row_index, value in enumerate(column_values):
        # Skip the value in row 2 because it is the model answer
        if row_index == row_2_index:
            continue

        # Convert both values to strings before comparison
        str_value = str(value)
        str_row_2_value = str(row_2[column_index + 4])  # Adjust the column index as only column 5 and above is required

        # Compare with answer row (row 2)
        if str_value != str_row_2_value and isinstance(value, str):
            # Increment the count in the dictionary
            value_counts[str_value] = value_counts.get(str_value, 0) + 1

    # Find the most common value for the current column
    most_common_value = max(value_counts, key=value_counts.get, default=None)

    # Store the least common value for the current column in the dictionary
    column_value_counts[df.columns[column_index + 4]] = most_common_value  # Adjust the column index

# Open the file in append mode and write the results
with open('info.txt', 'a') as file:
    # Append the least common value for each column to the file
    for column, least_common_value in column_value_counts.items():
        file.write(f"The least common value in column '{column}' not equal to row 2 is: {least_common_value}\n")

#download the txt file
urllib.request.urlretrieve('C:\Users\shrey\IdeaProjects\testing', 'downloaded_info.txt')
print("ininfo.txt downloaded successfully.")
