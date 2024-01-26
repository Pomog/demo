# Tree Rooting Algorithm for Undirected Graphs

This Java project implements a tree-rooting algorithm for undirected graphs using breadth-first search (BFS).

The algorithm traverses the graph, identifies paths, and roots the resulting tree.

## Overview

Imagine there is a set of balls on a table connected by strings (an undirected graph).
You lift one of the balls (it will be the root) until all the balls are lifted into the air,
thus creating a directed, unordered, unweighted, connected graph.

Balls and the connections between them are described by the `Vertex` class.

The `UndirectedGraphFactory` function creates an instance of such a set of interconnected balls.

The `TreeRooter` function simulates the structuring of these balls during the lifting of the entire structure from a chosen ball - the root. No properties of the connections (strings) are taken into account.

Each ball has information about which ball or balls it is connected to above - it becomes a parent, and which ball or balls it is connected to below - it becomes a child.

## Project Structure

- `UndirectedGraphFactory`: A factory class that generates an example undirected, unsorted graph represented by vertices.
- `Vertex`: A class representing a vertex in the graph, including its data, neighbors, parents, and children.
- `TreeRooter`: The main class implementing the tree-rooting algorithm using BFS.
- `Root_Demo`: A demo class showcasing the usage of the algorithm on the generated graph.

## Usage

To run the demo and see the rooted tree:

```bash
./gradlew build
java -cp build/classes/java/main algorithms.root.Root_Demo
```
or use any IDE

Make sure to handle the exception thrown in case of an invalid root index.

## Issues and TODOs

- [ ] **Improve Efficiency and Clarity**: Avoid using both 'edge' and 'edgeReversed' in `processNeighbor` for better efficiency and clarity. 
