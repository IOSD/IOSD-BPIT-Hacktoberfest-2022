sentence1 = input('Enter the first sentence:\n')
sentence2 = input('Enter the second sentence:\n')

def solution(sentence1, sentence2):
    set1 = set(sentence1.split())
    set2 = set(sentence2.split())
    
    # ^ A.symmetric_difference(B), & A.intersection(B)
    
    return sorted(list(set1^set2)), sorted(list(set1&set2)) 

print(solution(sentence1, sentence2))
