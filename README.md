# PDA and Leftmost Derivation for Grammar S → a S b | e

## Description
This project implements three algorithms for the context-free grammar:

**S → a S b | e**

- **Algorithm_1 (String Generator):** generates test strings over alphabet {a, b} (includes accepted and rejected examples).  
- **Algorithm_2 (Pushdown Automaton):** a deterministic PDA that recognizes L = { a^n b^n | n ≥ 0 }.  
- **Algorithm_3 (Leftmost Derivation):** construction of leftmost derivations (sentential forms) for strings accepted by the PDA.

The assignment statement was provided as part of the **Formal Languages** course at EAFIT UNIVERSITY.  

---

## Features
- Generates predefined **test strings** (including the empty string `e`).  
- PDA implementation with push/pop stack behavior.  
- Reports clearly whether each test string is **accepted** or **rejected**.  
- Builds **step-by-step leftmost derivations** only for the accepted strings.  
- Console-based program with reproducible and formatted outputs.

---

## Input / Output
- **Input:** The program does not require external input; it uses a predefined set of `testStrings` inside `Algorithm_1`.  
- **Output:** Printed to standard output, divided into three sections:

1. **Algorithm_1 – Generated Strings**  
2. **Algorithm_2 – PDA acceptance/rejection**  
3. **Algorithm_3 – Leftmost derivations** (only for accepted strings)

### Example Execution Output
### Example Output_Algorithm_1:
String: 'aaaaabbbbb'
String: 'ab'
String: ''
String: 'aabb'
String: 'aaaabbbb'
String: 'aab'
String: 'aabbbb'
String: 'bbbaaaa'

### Example Output_Algorithm_2:
The string 'aaaaabbbbb' is accepted by the PDA.
The string 'ab' is accepted by the PDA.
The string '' is accepted by the PDA.
The string 'aabb' is accepted by the PDA.
The string 'aaaabbbb' is accepted by the PDA.
The string 'aab' is rejected by the PDA.
The string 'aabbbb' is rejected by the PDA.
The string 'bbbaaaa' is rejected by the PDA.

### Example Output_Algorithm_3:
Leftmost derivation for string 'aaaaabbbbb':
S
a S b
a a S b b
a a a S b b b
a a a a S b b b b
a a a a a S b b b b b
a a a a a e b b b b b
aaaaabbbbb

Leftmost derivation for string 'ab':
S
a S b
a e b
ab

Leftmost derivation for string '':
S
e

Leftmost derivation for string 'aabb':
S
a S b
a a S b b
a a e b b
aabb

Leftmost derivation for string 'aaaabbbb':
S
a S b
a a S b b
a a a S b b b
a a a a S b b b b
a a a a e b b b b
aaaabbbb

---

## How to compile and run

### Requirements
- Java JDK (tested with OpenJDK 17, should work with JDK ≥ 11).

### Compile
```bash
javac Actividad2.java
java Actividad2
```

### Reference
Kozen, Dexter C. (1997). Automata and Computability. Lecture notes referenced in the course assignment.

### Authors
Emmanuel Castaño Sepúlveda
Jerónimo Contreras Sierra

### Course 
Professor: Adolfo Andrés Castro Sánchez
Course: Formal Languages (5465 – EAFIT)
