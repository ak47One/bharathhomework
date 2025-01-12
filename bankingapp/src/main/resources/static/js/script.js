document.addEventListener("DOMContentLoaded", function () {
    const fileInput = document.getElementById('excelFile');

    // Check if file type is Excel
    fileInput.addEventListener('change', function () {
        const file = fileInput.files[0];
        if (file) {
            const fileType = file.type;
            if (fileType !== 'application/vnd.ms-excel' && fileType !== 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet') {
                alert('Please upload a valid Excel file (.xls or .xlsx)');
                fileInput.value = ''; // Clear the file input
            }
        }
    });
});
