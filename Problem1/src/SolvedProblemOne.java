
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SolvedProblemOne {

	public static void main(String[] args) {
		try {

			File f = new File("Problem1_input.txt");

			List<String> lines = FileUtils.readLines(f, "UTF-8");

			int totalMsgLength = Integer.parseInt(lines.get(0));
			int lineNumber = 1;

			StringBuilder strBuilder = new StringBuilder();

			for (int i = 0; i < totalMsgLength; i++) {
				String line1 = lines.get(lineNumber);
				lineNumber++;
				String line2 = lines.get(lineNumber);
				lineNumber++;

				String[] lineOneArr = line1.split(" ");
				String[] lineTwoArr = line2.split(" ");

				int mx = Integer.parseInt(lineOneArr[0]);
				int k = Integer.parseInt(lineOneArr[1]);
				int l = Integer.parseInt(lineOneArr[2]);

				List<Long> inputList = new ArrayList<Long>();
				for (int a = 0; a < lineTwoArr.length; a++) {
					inputList.add(Long.parseLong(lineTwoArr[a]));
				}

				Collections.sort(inputList, Collections.reverseOrder());

				List<Long> outputList = new ArrayList<Long>();
				int inputCount = 0;

				for (int b = 1; b <= mx; b++) {
					for (int c = 0; c < k; c++) {
						if (inputCount < inputList.size()) {
							Long item = inputList.get(inputCount);
							outputList.add(item * b);
						}
						inputCount++;
					}
				}

				Optional<Long> opSum = outputList.stream().reduce((a, b) -> a + b);
				Long sum = opSum.get();

				strBuilder.append("Message-" + (i + 1) + ": " + sum);
				strBuilder.append("\n");

			}

			writeInOutputFile(strBuilder.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void writeInOutputFile(String str) {
		File file = new File("Problem1_output.txt");
		try {
			FileUtils.writeStringToFile(file, str);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
