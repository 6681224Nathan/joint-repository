
root = Node("a", age=90)
b = Node("b", age=65, parent=root)
c = Node("c", age=60, parent=root)

d = {"093483345" : ("alice", 500), "8475898473" : ("bob", 500)}





class Node:
    def __init__(self, key, left = None, right = None, value = None):
        self.key = key
        self.left = left
        self.right = right
        self.value = value

    def get_value(self):
        return self.value

n1 = Node(key = "Alice", value = 3.5)
n2 = Node(key = "Bob", left = n1, value = 3.9)


n2.right = n3
root = n2

root.right.get_value()

def search(node, k):
    if node is None or node.key == k:
        return node
    elif k < node.key:
        return search(node.left, k)
    else
        return search(node.right, k)
