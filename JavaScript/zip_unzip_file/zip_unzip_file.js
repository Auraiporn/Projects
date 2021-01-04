/**     A program prompts for a user to input a choice to zip or unzip a file, then a user will be asked to enter 
 *      the path of a file and the path of a target file.
 *      Usage: node zip_unzip_file.js
 *      Output: 
 *               Zip or Unzip: unzip
 *               Enter a path of a file: ./file.txt.gz
 *               Enter a path of a target file: uncompressed.txt
 *               unzip ./file.txt.gz uncompressed.txt
 *               Processing...
 *
 *               Succesfully converted a file!!
 *               BYE BYE !!!
 */

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

/** To zip a file */
const fs = require('fs');
// Module for compression of a file
const zlib = require('zlib');

rl.question("Zip or Unzip: ", function(choice) {
    rl.question("Enter a path of a file: ", function(file) {
        rl.question("Enter a path of a target file: ", function(targetFile) {
            console.log(`${choice} ${file} to ${targetFile}\nProcessing...`);
            // Zip a file 
            if(choice=="zip"){
                const gzip = zlib.createGzip();
                const readStream = fs.createReadStream(file);
                const writeStream = fs.createWriteStream(targetFile);
                readStream.pipe(gzip).pipe(writeStream);
            }
            // Unzip a file 
            if(choice=="unzip"){
                const gunzip = zlib.createGunzip();
                const readStream = fs.createReadStream(file);
                const writeStream = fs.createWriteStream(targetFile);
                readStream.pipe(gunzip).pipe(writeStream);

            }
            rl.close();
        });
    });
});

rl.on("close", function() {
    console.log("\nSuccesfully converted a file!! \nBYE BYE !!!");
    process.exit(0);
});