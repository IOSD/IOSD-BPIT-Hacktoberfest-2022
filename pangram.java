bool checkIfPangram(string s) {
  bool isFound[26]{false};
  int count{};

  for (char c : s) {
    int i = c - 'a';
    if (!isFound[i]) {
      isFound[i] = true;
      count++;
    }
  }
  return count == 26;
}