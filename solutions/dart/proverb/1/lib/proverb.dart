class Proverb {
  String recite(List<String> pieces) {
    if (pieces.isEmpty) {
      return '';
    }

    final lines = <String>[
      for (var index = 0; index < pieces.length - 1; index++)
        'For want of a ${pieces[index]} the ${pieces[index + 1]} was lost.',
      'And all for the want of a ${pieces.first}.',
    ];

    return lines.join('\n');
  }
}
