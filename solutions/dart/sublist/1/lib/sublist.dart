enum Classification {
  equal,
  sublist,
  superlist,
  unequal,
}

class Sublist {

  Classification sublist(List<int> a, List<int> b) {
    if (a.isEmpty && b.isNotEmpty) return Classification.sublist;
    if (b.isEmpty && a.isNotEmpty) return Classification.superlist;
    if (a.length == b.length) {
      for (var i = 0; i < a.length; i++) {
        if (a[i] != b[i]) return Classification.unequal;
      }
      return Classification.equal;
    }
    if (a.length < b.length) {
      if (_isContained(a, b)) return Classification.sublist;
    } else {
      if (_isContained(b, a)) return Classification.superlist;
    }
    return Classification.unequal;
  }

  bool _isContained(List<int> a, List<int> b) {
    final lastPos = b.length - a.length;
    for (var startPos = 0; startPos <= lastPos; startPos++) {
      var matches = true;
      for (var i = 0; i < a.length; i++) {
        if (a[i] != b[startPos + i]) {
          matches = false;
          break;
        }
      }
      if (matches) {
        return true;
      }
    }
    return false;
  }
}
